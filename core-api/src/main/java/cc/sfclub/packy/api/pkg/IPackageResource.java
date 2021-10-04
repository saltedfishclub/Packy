package cc.sfclub.packy.api.pkg;

import cc.sfclub.packy.api.cache.ICache;

import java.nio.file.Path;
import java.util.Optional;

public interface IPackageResource {
    /**
     * path == cache
     */
    Optional<ICache> cache();
    String name();
    boolean isCached();
    String getResourceID();
}
