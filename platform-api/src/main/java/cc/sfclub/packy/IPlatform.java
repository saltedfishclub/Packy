package cc.sfclub.packy;

import cc.sfclub.packy.cache.ICacheProvider;
import com.github.zafarkhaja.semver.Version;
import org.jetbrains.annotations.ApiStatus;

/**
 * Represents some api depends on platforms.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IPlatform{
    /**
     *
     * @return Platform Semantic Version
     */
    Version getVersion();

    /**
     *
     * @return Platform-provided Cache provider
     */
    ICacheProvider getCacheProvider();

    /**
     *
     * @return Platform's name
     */
    String getName();

    /**
     * lowercase always
     * @return Architecture of the platform
     */
    String getArch();
    //todo other DSL things
}
