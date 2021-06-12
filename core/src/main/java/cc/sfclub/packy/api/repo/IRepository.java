package cc.sfclub.packy.api.repo;

import org.jetbrains.annotations.ApiStatus;

/**
 * A Repository, nobody cares where it comes from.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IRepository {
    String getName();
    IChannel getUsingChannel();
}
