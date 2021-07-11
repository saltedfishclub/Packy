package cc.sfclub.packy.api.pkg;

import cc.sfclub.packy.api.DependencyCheckResult;
import cc.sfclub.packy.api.PackageCoordinate;
import cc.sfclub.packy.executor.InstallResult;

import java.util.List;

public interface IPackageManager {
    InstallResult install(IPackageVersion info);
    boolean uninstall(IPackageVersion info);
    DependencyCheckResult solveDependencies(IPackageVersion info);
    List<IPackageVersion> searchAllRepos(String keywords);
    IPackageVersion searchByCoord(PackageCoordinate coordinate);
}
