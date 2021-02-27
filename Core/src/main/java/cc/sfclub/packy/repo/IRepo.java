package cc.sfclub.packy.repo;

import cc.sfclub.packy.repo.data.local.PackageInfo;
import org.jetbrains.annotations.ApiStatus;

import java.util.Set;

/**
 * 一个仓库
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepo {
    Set<PackageInfo> searchPackages(String keywords);

    boolean refresh();
}
