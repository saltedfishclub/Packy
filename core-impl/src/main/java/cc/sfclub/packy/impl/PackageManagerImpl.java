package cc.sfclub.packy.impl;

import cc.sfclub.packy.api.DependencyCheckResult;
import cc.sfclub.packy.api.EnvironmentRequirement;
import cc.sfclub.packy.api.InstallEnvironment;
import cc.sfclub.packy.api.exception.*;
import cc.sfclub.packy.api.pkg.IPackageManager;
import cc.sfclub.packy.api.pkg.IPackageVersion;
import cc.sfclub.packy.api.PackageCoordinate;
import cc.sfclub.packy.api.repo.IChannel;
import cc.sfclub.packy.api.repo.IRepository;
import cc.sfclub.packy.api.multiplatform.IEnvResolver;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class PackageManagerImpl implements IPackageManager {
    private final PackyImpl packy;

    @Override
    public boolean install(IPackageVersion info, InstallEnvironment env) throws PackageConflictException, EnvironmentNotCompatible {
        if (info.isLocal()) {
            throw new PackageAlreadyExists(Collections.singletonList(info));
        }
        List<IPackageVersion> res = searchAllRepos(info.getName(),true);
        Stream<IPackageVersion> a = res.stream().filter(e -> e.getName().equals(info.getName())).filter(e->e.getVersion().greaterThanOrEqualTo(info.getVersion()));
        boolean newerOrExists = a.count()!=0;
        if (newerOrExists) {
            throw new PackageConflictException(a.collect(Collectors.toList()),true);
        }
        DependencyCheckResult result = checkDependencies(info);
        if (result.getConflicts().size() != 0) {
            throw new PackageConflictException(result.getConflicts());
        }
        if(result.getMissingDeps().size()!=0){
            throw new PackageMissing(result.getMissingDeps());
        }
        if (info.getInstaller() != null) {
            packy.getExecutor().install(info, info.getInstaller(), env.getPermission()!=null?env.getPermission():packy.getConfig().defaultPackagePermission_Install);
        }
        boolean compat=info.getEnv().stream().allMatch(this::solveEnvironmentRequirement);
        for (EnvironmentRequirement environmentRequirement : info.getEnv()) {
            if (!solveEnvironmentRequirement(environmentRequirement)) {
                throw new EnvironmentNotCompatible(environmentRequirement);
            }
        }
        info.setLocal(true);
        boolean az = info.from().repository().getLocalChannel().add(info);
        return az;
    }

    @Override
    public boolean uninstall(IPackageVersion info,InstallEnvironment env) throws PackageNotLocalException {
        if (!info.isLocal()) {
            throw new PackageNotLocalException(info.getCoordinate().toString());
        }
        if (info.getUninstaller() != null) {
            return packy.getExecutor().install(info,info.getUninstaller(),env.getPermission()==null?packy.getConfig().defaultPackagePermission_UnInstall:env.getPermission());
        } else {
            return false;
        }
    }

    @Override
    public DependencyCheckResult checkDependencies(IPackageVersion info) {
        List<EnvironmentRequirement> conflicts = new ArrayList<>();
        List<EnvironmentRequirement> missing = new ArrayList<>();
        for (EnvironmentRequirement conflict : info.getConflicts()) {
            List<IPackageVersion> res = searchAllRepos(conflict.getTarget(),true);
            for (IPackageVersion re : res) {
                if(re.getVersion().satisfies(conflict.getCondition())){
                    conflicts.add(conflict);
                }
            }
        }
        for (EnvironmentRequirement depend : info.getDepends()) {
            List<IPackageVersion> res = searchAllRepos(depend.getTarget(),true);
            if(res.size()==0){
                missing.add(depend);
            }else{
                List<IPackageVersion> a =new ArrayList<>();
                for (IPackageVersion re : res) {
                    if(re.getName().equals(depend.getTarget())){
                        if(re.getVersion().satisfies(depend.getTarget())){
                            a.add(re);
                        }
                    }
                }
                if(a.size()==0){
                    missing.add(depend);
                }
            }
        }
        return new DependencyCheckResult(conflicts,missing);
    }

    @Override
    public List<IPackageVersion> searchAllRepos(String keywords,boolean local) {
        List<IPackageVersion> result=new ArrayList<>();
        for (IRepository repository : packy.getRepositories()) {
            IChannel<IPackageVersion> channel = local?repository.getLocalChannel(): repository.getRemoteChannel();
            result.addAll(channel.fetchFor(keywords));
        }
        return result;
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
