package cc.sfclub.packy.script;

import cc.sfclub.packy.OperationSession;
import cc.sfclub.packy.repo.data.remote.PackageScript;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.AvailableSince("0.1.0")
public interface InstallScriptExecutor {
    boolean install(OperationSession session, PackageScript cmds);

    boolean uninstall(OperationSession session, PackageScript cmds);

    boolean preinstall(OperationSession session, PackageScript cmds);
}
