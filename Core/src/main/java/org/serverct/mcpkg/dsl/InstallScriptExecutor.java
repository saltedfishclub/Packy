package org.serverct.mcpkg.dsl;

import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.AvailableSince("0.1.0")
public interface InstallScriptExecutor {
    boolean execute(List<AbstractCommand> cmds);
}
