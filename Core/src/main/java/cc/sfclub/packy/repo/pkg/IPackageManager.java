package cc.sfclub.packy.repo.pkg;

import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import cc.sfclub.packy.session.OperationSession;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@ApiStatus.AvailableSince("0.1.0")
public interface IPackageManager {
    void refreshAllRepos();

    boolean install(OperationSession session);

    List<AbstractPackageInfo> searchPackages(String kw);

    boolean removePackage(String pkgName);

    AbstractPackageInfo getPackageInfo(String repoName, String pkgName, @Nullable String ver);

    void cleanCache();

    List<AbstractPackageInfo> getInstalledPackages();

    AbstractPackageInfo parse(String expr);

}
