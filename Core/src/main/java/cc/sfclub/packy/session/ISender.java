package cc.sfclub.packy.session;

import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;
import java.util.function.Consumer;

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

    void waitChoice(Consumer<Choice> callback);

    enum Choice {
        TIMEOUT, YES, NO
    }
}
