package org.serverct.mcpkg.impl.dsl.commands;

import org.serverct.mcpkg.dsl.AbstractCommand;
import org.serverct.mcpkg.dsl.CommandResult;

//运行MC控制台命令，这个不着急写。
public class ExecMC extends AbstractCommand {
    public ExecMC(String cmd) {
        super(cmd);
    }

    @Override
    public CommandResult execute() {
        return null;
    }
}
