package org.serverct.mcpkg.command;

import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.repo.data.local.PackageInfo;

import java.util.List;

@ApiStatus.AvailableSince("0.1.0")
public interface ISender {
    void sendPackageList(List<PackageInfo> packages);

    void sendProgressBar(int location);

    void sendMessage(String message);

    /**
     * Blocking.
     *
     * @return result
     */
    boolean waitChoice();
}
