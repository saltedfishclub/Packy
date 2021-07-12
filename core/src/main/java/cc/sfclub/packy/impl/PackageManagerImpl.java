package cc.sfclub.packy.impl;

import cc.sfclub.packy.api.DependencyCheckResult;
import cc.sfclub.packy.api.EnvironmentRequirement;
import cc.sfclub.packy.api.exception.EnvironmentNotCompatible;
import cc.sfclub.packy.api.exception.PackageAlreadyExists;
import cc.sfclub.packy.api.exception.PackageConflictException;
import cc.sfclub.packy.api.exception.PackageMissing;
import cc.sfclub.packy.api.pkg.IPackageManager;
import cc.sfclub.packy.api.pkg.IPackageVersion;
import cc.sfclub.packy.api.PackageCoordinate;
import cc.sfclub.packy.executor.IEnvResolver;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;

@RequiredArgsConstructor
public class PackageManagerImpl implements IPackageManager {
    private final Packy packy;

    @Override
    public boolean install(IPackageVersion info) throws PackageConflictException, EnvironmentNotCompatible {
        if (info.isLocal()) {
            throw new PackageAlreadyExists(Collections.singletonList(info));
        }
        List<IPackageVersion> res = searchAllRepos(info.getName());
        boolean newerOrExists = searchAllRepos(info.getName()).stream().filter(e -> e.getName().equals(info.getName())).allMatch(e -> e.getVersion().greaterThanOrEqualTo(info.getVersion()));
        if (newerOrExists) {
            throw new PackageConflictException(res);
        }
        DependencyCheckResult result = checkDependencies(info);
        if (result.getConflicts().size() != 0) {
            throw new PackageConflictException(result.getConflicts());
        }
        if(result.getMissingDeps().size()!=0){
            throw new PackageMissing(result.getMissingDeps());
        }
        if (info.getInstaller() != null) {
            packy.getExecutor().install(info, info.getInstaller(), packy.getConfig().defaultPackagePermission_Install);
        }
        boolean compat=info.getEnv().stream().allMatch(this::solveEnvironmentRequirement);
        for (EnvironmentRequirement environmentRequirement : info.getEnv()) {
            if (!solveEnvironmentRequirement(environmentRequirement)) {
                throw new EnvironmentNotCompatible(environmentRequirement);
            }
        }
        info.setLocal(true);
        boolean a = info.from().repository().getLocalChannel().add(info);
        return a;
    }

    @Override
    public boolean uninstall(IPackageVersion info) {
        if (!info.isLocal()) {
            return new InstallResult(packy.getLocale().Package_Should_Be_Local, false);
        }
        if (info.getUninstaller() != null) {
            return
        } else {

        }
    }

    @Override
    public DependencyCheckResult checkDependencies(IPackageVersion info) {
        return null;
    }

    @Override
    public List<IPackageVersion> searchAllRepos(String keywords) {
        return null;
    }

    @Override
    public IPackageVersion searchByCoord(PackageCoordinate coordinate) {
        return null;
    }

    @Override
    public boolean solveEnvironmentRequirement(EnvironmentRequirement er) {
        for (IEnvResolver iEnvResolver : ServiceLoader.load(IEnvResolver.class)) {
            if(!iEnvResolver.solve(er))return false;
        }
        return true;
    }
}
