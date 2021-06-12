package cc.sfclub.packy.api.tracker;

import cc.sfclub.packy.api.IPackageVersion;
import org.jetbrains.annotations.ApiStatus;

/**
 * A tracker is designed to track files which touched by Package's Installer.
 * It's used to debug and find malware codes.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface ITracker {
    void record(IPackageVersion meta, String action);
}
