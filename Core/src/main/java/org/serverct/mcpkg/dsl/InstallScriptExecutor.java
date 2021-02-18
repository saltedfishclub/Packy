package org.serverct.mcpkg.dsl;

import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.OperationSession;

import java.util.List;

@ApiStatus.AvailableSince("0.1.0")
public interface InstallScriptExecutor {
    boolean execute(OperationSession session, List<AbstractCommand> cmds);
}
