package cc.sfclub.packy.cache;

import cc.sfclub.packy.util.Pair;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Cache Path Factory, always provided by implementation of platform-api
 */
@ApiStatus.AvailableSince("0.2.0")
public interface ICacheProvider {
    Path allocate();
    Optional<Path> getCacheByID(UUID uuid);
    Collection<Path> caches();
}
