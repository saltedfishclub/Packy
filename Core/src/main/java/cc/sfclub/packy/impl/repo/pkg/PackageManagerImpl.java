package cc.sfclub.packy.impl.repo.pkg;

import cc.sfclub.packy.provider.IRepoProvider;
import cc.sfclub.packy.repo.IRepo;
import cc.sfclub.packy.repo.data.local.PackageInfo;
import cc.sfclub.packy.repo.pkg.IPackageManager;
import cc.sfclub.packy.session.OperationSession;
import com.dieselpoint.norm.Database;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class PackageManagerImpl implements IPackageManager {
    private List<IRepoProvider> providers = new ArrayList<>();
    private List<IRepo> repos = new ArrayList<>();
    private Database localDb;

    public void initProviders() {
        ServiceLoader.load(IRepoProvider.class).forEach(providers::add);
    }

    @Override
    public void refreshAllRepos() {
        providers.forEach(e -> repos.addAll(e.getRepoList()));
    }

    @Override
    public boolean install(OperationSession pkg) {
        return false;
    }

    @Override
    public List<PackageInfo> searchPackages(String kw) {
        List<PackageInfo> info = new ArrayList<>();
        repos.forEach(e -> info.addAll(e.searchPackages(kw)));
        return info;
    }

    @Override
    public boolean removePackage(String pkgName) {
        List<PackageInfo> infos = searchPackages(pkgName);
        if (!infos.stream().allMatch(PackageInfo::isLocal)) {
            return false;
        }
        infos.forEach(e -> {
            //todo
        });
        return true;
    }

    @Override
    public PackageInfo getPackageInfo(String repoName, String pkgName, @Nullable String ver) {
        return repos.stream().filter(e -> e.getName().equals(repoName)).findFirst().orElseThrow(() -> new NullPointerException("Cannot find repo " + repoName)).getPackage(pkgName, ver);
    }

    @Override
    public void cleanCache() {

    }

    @Override
    public List<PackageInfo> getInstalledPackages() {
        return null;
    }

    @Override
    public List<String> getTrackingFiles(PackageInfo pkg) {
        return null;
    }
}
