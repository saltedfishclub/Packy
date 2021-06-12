package cc.sfclub.packy.api;

import cc.sfclub.packy.api.cache.ICache;

import java.nio.file.Path;
import java.util.Optional;

public interface IPackageResource {
    /**
     * path == cache
     */
    Optional<ICache> cache();
    boolean isCached();
    String getResourceID();
}
