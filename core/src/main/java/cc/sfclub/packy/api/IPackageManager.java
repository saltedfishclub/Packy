package cc.sfclub.packy.api;

import java.util.List;

public interface IPackageManager {
    boolean install(IPackageMeta info);
    boolean uninstall(IPackageMeta info);
    DependencyCheckResult solveDependencies(IPackageMeta info);
    List<IPackageMeta> searchAllRepos(String keywords);
}
