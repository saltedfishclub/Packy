package cc.sfclub.packy.repo.pkg;

import cc.sfclub.packy.repo.data.local.PackageInfo;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.AvailableSince("0.1.0")
public interface IPackageManager {
    boolean refreshAllRepos();

    boolean install(PackageInfo pkg);

    List<PackageInfo> searchPackages(String kw);

    boolean removePackage(String pkgName);

    PackageInfo getPackageInfo(String repoName, String pkgName);

    void cleanCache();

    List<PackageInfo> getInstalledPackages();

    List<String> getPkgTrackingFiles(PackageInfo pkg);

}
