package cc.sfclub.packy.impl.repo.pkg;

import cc.sfclub.packy.impl.RepoFinder;
import cc.sfclub.packy.provider.IRepoProvider;
import cc.sfclub.packy.repo.IRepo;
import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import cc.sfclub.packy.repo.pkg.IPackageManager;
import cc.sfclub.packy.session.OperationSession;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PackageManagerImpl implements IPackageManager {
    private List<IRepoProvider> providers = new ArrayList<>();
    @Getter
    private List<IRepo> repos;

    public PackageManagerImpl() {
        repos = new ArrayList<>(RepoFinder.findInstance().values());
    }

    @Override
    public void refreshAllRepos() {
        providers.forEach(e -> repos.addAll(e.getRepoList()));
    }

    @Override
    public boolean install(OperationSession pkg) {
        pkg.
    }

    @Override
    public List<AbstractPackageInfo> searchPackages(String kw) {
        List<AbstractPackageInfo> info = new ArrayList<>();
        repos.forEach(e -> info.addAll(e.searchPackages(kw)));
        return info;
    }

    @Override
    public boolean removePackage(String pkgName) {
    }

    @Override
    public AbstractPackageInfo getPackageInfo(String repoName, String pkgName, @Nullable String ver) {
        return repos.stream().filter(e -> e.getName().equals(repoName)).findFirst().orElseThrow(() -> new NullPointerException("Cannot find repo " + repoName)).getPackage(pkgName, ver);
    }

    @Override
    public void cleanCache() {

    }

    @Override
    public List<AbstractPackageInfo> getInstalledPackages() {
        return null;
    }

    @Override
    public AbstractPackageInfo parse(String expr) {
        return null;
    }

}
