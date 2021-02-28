package cc.sfclub.packy.repo.pkg;

import cc.sfclub.packy.OperationSession;
import cc.sfclub.packy.repo.data.local.PackageInfo;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@ApiStatus.AvailableSince("0.1.0")
public interface IPackageManager {
    void refreshAllRepos();

    boolean install(OperationSession session);

    List<PackageInfo> searchPackages(String kw);

    boolean removePackage(String pkgName);

    PackageInfo getPackageInfo(String repoName, String pkgName, @Nullable String ver);

    void cleanCache();

    List<PackageInfo> getInstalledPackages();

    List<String> getPkgTrackingFiles(PackageInfo pkg);

}
