package cc.sfclub.packy.repo.data.local;

import cc.sfclub.packy.Packy;
import cc.sfclub.packy.script.ScriptEnv;
import cc.sfclub.packy.util.SafeLevels;
import cc.sfclub.packy.util.ScriptEval;
import cc.sfclub.packy.util.StringConsts;
import com.github.zafarkhaja.semver.Version;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Entity;
import java.io.File;
import java.util.List;
import java.util.Locale;

@Entity
@ApiStatus.AvailableSince("0.1.0")
@Getter
@AllArgsConstructor
public final class PackageInfo implements Cloneable {
    private transient static final Gson gson = new Gson();
    private String name;
    private String repo;
    private String version;
    @Nullable
    private String mcVersion;
    private String javaVersion;
    private List<String> arch;
    private String description;

    private long lastUpdated;
    private String gpgAssignee;
    private String zipDownloadUrl;
    private String gpgDownloadUrl;

    /**
     * Make sure that expr is `repo/name[:ver]`
     *
     * @param expr
     * @return
     */
    @Nullable
    public static PackageInfo parse(String expr) {
        String[] s = expr.split("/"); //plugins/WorldEdit:2.0
        if (s.length != 2) {
            return null;
        }
        String repo = s[0]; //plugins
        String name = s[1]; //WorldEdit:2.0
        String[] s2 = name.split(":"); //WorldEdit,2.0
        if (s2.length == 2) {
            //SemVersionRegion region = new SemVersionRegion(s2[1]);
            Version version = Version.valueOf(s2[1]);
            PackageInfo info = fetch(repo, s2[0], null);
            //return region.isInRegion(info.version) ? info : null;
            return version.satisfies(info.version) ? info : null;
        }
        return fetch(repo, name, null);
    }
    /**
     * @param repo
     * @param name
     * @param version nullable when specified ANY version
     * @return
     */
    private static PackageInfo fetch(String repo, String name, @Nullable String version) {
        PackageInfo i = Packy.getImpl().getPackageManager().getPackageInfo(StringConsts.LOCAL_PLUGINS_REPOSITORY, name, version);
        if (i != null) {
            return i;
        }
        return Packy.getImpl().getPackageManager().getPackageInfo(repo, name, version);
    }

    public static boolean checkCompatibility(PackageInfo info) {
        boolean mcver = true;
        boolean javaver = true;
        boolean arch = true;
        if (info.getMcVersion() != null) {
            Version version = Version.valueOf(info.getMcVersion());
            if (version.satisfies(Packy.getImpl().getMinecraftUtil().getMCVer())) {
                mcver = false;
            }
        }
        if (info.getJavaVersion() != null) {
            javaver = new ScriptEval(new ScriptEnv(), SafeLevels.HIGH).boolEval(info.getJavaVersion());
        }
        arch = info.arch.contains(Packy.getImpl().getMinecraftUtil().getArch().toLowerCase(Locale.ROOT));
        return mcver && javaver && arch;
    }

    public File getCacheLoc() {
        return new File(StringConsts.CACHE_LOCATION_FOTMAT.replaceAll("%cache_dir", Packy.getImpl().getCacheDir())
                .replaceAll("%repo", repo)
                .replaceAll("%package", name)
                .replaceAll("%version", version));
    }

    public File getGpgSignLoc() {
        return new File(StringConsts.CACHE_LOCATION_FOTMAT.replaceAll("%cache_dir", Packy.getImpl().getCacheDir())
                .replaceAll("%repo", repo)
                .replaceAll("%package", name)
                .replaceAll("%version", version + "-gpgsign"));
    }

    public String getFullName() {
        return repo + "/" + name;
    }

    public String getFullNameWithVersion() {
        return repo + "/" + name + ":" + version;
    }

    @Override
    public PackageInfo clone() {
        return gson.fromJson(gson.toJson(this), PackageInfo.class);
    }
}
