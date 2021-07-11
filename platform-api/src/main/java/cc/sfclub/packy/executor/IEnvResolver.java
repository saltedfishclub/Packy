package cc.sfclub.packy.executor;

import cc.sfclub.packy.api.EnvironmentRequirement;
import org.jetbrains.annotations.ApiStatus;

/**
 * Should be registered as a Service.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IEnvResolver {
    boolean solve(EnvironmentRequirement requirement);
}
