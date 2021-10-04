package cc.sfclub.packy.api.cache;

import org.jetbrains.annotations.ApiStatus;

import java.nio.file.Path;

@ApiStatus.AvailableSince("0.2.0")
public interface ICache {
    Path get();
    boolean isClosed();
    void close();
}
