package cc.sfclub.packy.tracker;

import org.jetbrains.annotations.ApiStatus;

/**
 * A tracker is designed to track files which touched by Package's Installer.
 * It's used to debug and find malware codes.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IFileTracker {
    //todo Designation depends on Packy DSL
}
