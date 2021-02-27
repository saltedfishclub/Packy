package cc.sfclub.packy.repo;

import cc.sfclub.packy.repo.data.local.PackageInfo;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

/**
 * 一个仓库
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepo {
    String getName();

    List<PackageInfo> searchPackages(String keywords);

    boolean tryRefresh(boolean force);
}
