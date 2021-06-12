package cc.sfclub.packy.api.providers;

import cc.sfclub.packy.api.cache.ICache;
import org.jetbrains.annotations.ApiStatus;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Cache Path Factory, always provided by implementation of platform-api
 */
@ApiStatus.AvailableSince("0.2.0")
public interface ICacheProvider {
    ICache allocate();
    Optional<ICache> getCacheByID(UUID uuid);
    Collection<ICache> caches();
}
