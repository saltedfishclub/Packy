package cc.sfclub.packy.script;

import cc.sfclub.packy.session.OperationSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.AvailableSince("0.1.0")
public interface ScriptExecutor {
    boolean execute(OperationSession session, String script);
}
