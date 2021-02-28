package cc.sfclub.packy.repo;

import cc.sfclub.packy.repo.data.local.PackageInfo;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 一个仓库
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepo {
    String getName();

    List<PackageInfo> searchPackages(String keywords);

    PackageInfo getPackage(String name, @Nullable String version);

    boolean tryRefresh(boolean force);
}
