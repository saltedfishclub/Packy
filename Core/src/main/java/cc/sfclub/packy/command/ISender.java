package cc.sfclub.packy.command;

import cc.sfclub.packy.repo.data.local.PackageInfo;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.AvailableSince("0.1.0")
public interface ISender {
    /**
     * PLayer offline etc.
     *
     * @return if available
     */
    boolean isAvailable();

    void sendPackageList(List<PackageInfo> packages);

    void sendProgressBar(String task, int location);

    void sendMessage(String message);

    /**
     * Blocking.
     *
     * @return result
     */
    boolean waitChoice();
}
