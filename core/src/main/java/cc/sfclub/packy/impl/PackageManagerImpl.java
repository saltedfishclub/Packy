package cc.sfclub.packy.impl;

import cc.sfclub.packy.api.DependencyCheckResult;
import cc.sfclub.packy.api.pkg.IPackageManager;
import cc.sfclub.packy.api.pkg.IPackageVersion;
import cc.sfclub.packy.api.PackageCoordinate;
import cc.sfclub.packy.executor.InstallResult;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PackageManagerImpl implements IPackageManager {
    private final Packy packy;
    @Override
    public InstallResult install(IPackageVersion info) {
        if(info.isLocal()){
            return new InstallResult(packy.getLocale().Package_Install_Conflict_PackageAlreadyInstalled,false);
        }
        List<IPackageVersion> res=searchAllRepos(info.getName());
        boolean newerOrExists = searchAllRepos(info.getName()).stream().filter(e->e.getName().equals(info.getName())).allMatch(e->e.getVersion().greaterThanOrEqualTo(info.getVersion()));
        if(newerOrExists){
            return new InstallResult(packy.getLocale().Package_Install_Conflict_NewerOrDuplicate,false);
        }

        if(info.getInstaller() != null){
            //todo Execute
        }
        info.setLocal(true);
        boolean a=info.from().repository().getLocalChannel().add(info);
        //packy.getStorage().byType(IPackageVersion.class).append(Collections.singletonList(info));
        return new InstallResult(a?"Installation succeed":"Failed to install",a);
    }

    @Override
    public boolean uninstall(IPackageVersion info) {
        return false;
    }

    @Override
    public DependencyCheckResult solveDependencies(IPackageVersion info) {
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
}
