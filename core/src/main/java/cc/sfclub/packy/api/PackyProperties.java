package cc.sfclub.packy.api;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;

/**
 * Config.
 */
@ApiStatus.AvailableSince("0.2.0")
@Builder
@Getter
public class PackyProperties {
    @Builder.Default
    private String cacheLocation=System.getProperty("user.home")+"/.cache/packy";

}
