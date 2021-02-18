package org.serverct.mcpkg.dsl;

import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.OperationSession;
import org.serverct.mcpkg.repo.data.remote.PackageScript;

@ApiStatus.AvailableSince("0.1.0")
public interface InstallScriptExecutor {
    boolean install(OperationSession session, PackageScript cmds);

    boolean uninstall(OperationSession session, PackageScript cmds);

    boolean preinstall(OperationSession session, PackageScript cmds);
}
