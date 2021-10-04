package cc.sfclub.packy.api.pkg;

import cc.sfclub.packy.api.DependencyCheckResult;
import cc.sfclub.packy.api.EnvironmentRequirement;
import cc.sfclub.packy.api.InstallEnvironment;
import cc.sfclub.packy.api.PackageCoordinate;
import cc.sfclub.packy.api.exception.EnvironmentNotCompatible;
import cc.sfclub.packy.api.exception.PackageConflictException;
import cc.sfclub.packy.api.exception.PackageNotLocalException;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

/**
 * This api is mainly for UI.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IPackageManager {
    boolean install(IPackageVersion info, InstallEnvironment environment) throws PackageConflictException, EnvironmentNotCompatible;
    boolean uninstall(IPackageVersion info, InstallEnvironment environment) throws PackageNotLocalException;
    DependencyCheckResult checkDependencies(IPackageVersion info);
    List<IPackageVersion> searchAllRepos(String keywords,boolean local);
    IPackageVersion searchByCoord(PackageCoordinate coordinate);
    boolean solveEnvironmentRequirement(EnvironmentRequirement er) throws EnvironmentNotCompatible;
}
