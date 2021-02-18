package org.serverct.mcpkg.impl.dsl.commands;

import org.serverct.mcpkg.dsl.AbstractCommand;
import org.serverct.mcpkg.dsl.CommandResult;

//运行系统命令
public class ExecSys extends AbstractCommand {
    public ExecSys(String cmd) {
        super(cmd);
    }

    @Override
    public CommandResult execute() {
        return null;
    }
}
