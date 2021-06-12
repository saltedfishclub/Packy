package cc.sfclub.packy.api;

import java.nio.file.Path;
import java.util.Optional;

public interface IPackageResource {
    /**
     * path == cache
     */
    Optional<Path> cache();
    boolean isCached();
    String getResourceID();
}
