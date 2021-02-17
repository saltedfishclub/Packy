package org.serverct.mcpkg.repo.pkg;

import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.OperationSession;
import org.serverct.mcpkg.repo.data.local.PackageInfo;

@ApiStatus.AvailableSince("0.1.0")
public interface Installer {

    /**
     * 记得检查版本来判断是否是 update
     *
     * @param packageInfo
     * @param session
     * @return
     */
    boolean install(PackageInfo packageInfo, OperationSession session);
}
