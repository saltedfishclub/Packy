package cc.sfclub.packy.impl.repo;

import cc.sfclub.packy.repo.IRepo;
import cc.sfclub.packy.repo.data.local.PackageInfo;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class DefaultRepoImpl implements IRepo {
    private final Set<String> urls;
    private final String repoName;

    //todo 完善，对接 DAL
    @Override
    public Set<PackageInfo> searchPackages(String keywords) {

        return null;
    }

    @Override
    public boolean refresh() {
        return false;
    }
}
