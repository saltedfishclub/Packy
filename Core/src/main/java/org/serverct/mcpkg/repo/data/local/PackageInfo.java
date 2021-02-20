package org.serverct.mcpkg.repo.data.local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.serverct.mcpkg.MCPkg;
import org.serverct.mcpkg.script.ScriptEnv;
import org.serverct.mcpkg.util.SafeLevels;
import org.serverct.mcpkg.util.ScriptEval;
import org.serverct.mcpkg.util.SemVersionRegion;
import org.serverct.mcpkg.util.StringConsts;

import java.util.List;
import java.util.Locale;

@ApiStatus.AvailableSince("0.1.0")
@Getter
@AllArgsConstructor
public final class PackageInfo {
    private String name;
    private String repo;
    private String version;
    @Nullable
    private String mcVersion;
    private String javaVersion;
    private List<String> arch;
    private String description;

    private long lastUpdated;
    private boolean gpgSigned;
    private String downloadUrl;

    /**
     * Make sure that expr is `repo/name[:ver]`
     *
     * @param expr
     * @return
     */
    @Nullable
    public static PackageInfo parse(String expr) {
        String[] s = expr.split("/");
        if (s.length != 2) {
            return null;
        }
        String repo = s[0];
        String name = s[1];
        String[] s2 = name.split(":");
        if (s2.length == 2) {
            SemVersionRegion region = new SemVersionRegion(s2[2]);
            PackageInfo info = fetch(repo, name);
            return region.isInRegion(info.version) ? info : null;
        }
        return null;
    }

    private static PackageInfo fetch(String repo, String name) {
        PackageInfo i = MCPkg.getImpl().getPackageManager().getPackageInfo(StringConsts.LOCAL_PLUGINS_REPOSITORY, name);
        if (i != null) {
            return i;
        }
        return MCPkg.getImpl().getPackageManager().getPackageInfo(repo, name);
    }

    public static boolean checkCompatibility(PackageInfo info) {
        boolean mcver = true;
        boolean javaver = true;
        boolean arch = true;
        if (info.getMcVersion() != null) {
            SemVersionRegion region = new SemVersionRegion(info.getMcVersion());
            if (!region.isInRegion(MCPkg.getImpl().getMinecraftUtil().getMCVer())) {
                mcver = false;
            }
        }
        if (info.getJavaVersion() != null) {
            javaver = new ScriptEval(new ScriptEnv(), SafeLevels.HIGH).boolEval(info.getJavaVersion());
        }
        arch = info.arch.contains(MCPkg.getImpl().getMinecraftUtil().getArch().toLowerCase(Locale.ROOT));
        return mcver && javaver && arch;
    }

    public String getFullName() {
        return repo + "/" + name;
    }
}
