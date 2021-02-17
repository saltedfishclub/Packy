package org.serverct.mcpkg.command;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.AvailableSince("0.1.0")
public interface ICommandProcessor {
    void handle(String command);
}
