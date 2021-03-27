package cc.sfclub.packy.session;

import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
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

    void sendPackageList(List<AbstractPackageInfo> packages);

    void sendProgressBar(String task, int location);

    void sendMessage(String message);

    /**
     * Blocking.
     *
     * @return result
     */
    boolean waitChoice();
}
