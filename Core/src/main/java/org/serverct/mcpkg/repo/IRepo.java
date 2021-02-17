package org.serverct.mcpkg.repo;

import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.repo.data.local.PackageInfo;

import java.util.Set;

/**
 * 一个仓库
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepo {
    Set<PackageInfo> searchPackages(String keywords);

    boolean refresh();
}
