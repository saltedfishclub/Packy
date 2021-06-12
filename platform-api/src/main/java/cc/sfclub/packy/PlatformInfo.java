package cc.sfclub.packy;

import cc.sfclub.packy.api.providers.ICacheProvider;
import com.github.zafarkhaja.semver.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.ApiStatus;

/**
 * Represents some api depends on platforms.
 */
@ApiStatus.AvailableSince("0.2.0")
@Getter
@AllArgsConstructor
public class PlatformInfo {
    /**
     *
     * @return Platform Semantic Version
     */
    private final Version version;
    /**
     *
     * @return Platform's name
     */
    private final String name;

    /**
     * lowercase always
     * @return Architecture of the platform
     */
     private final String arch;
}
