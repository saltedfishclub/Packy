package cc.sfclub.packy.repo;

import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 一个仓库
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepo {
    String getName();

    List<AbstractPackageInfo> searchPackages(String keywords);

    AbstractPackageInfo getPackage(String name, @Nullable String version);

    boolean tryRefresh(boolean force);

    /**
     * Make sure that expr is `repo/name[:ver]`
     *
     * @param expr
     * @return
     */
    @Nullable
    AbstractPackageInfo parse(String expr);
}
