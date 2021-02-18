package org.serverct.mcpkg.impl.dsl.commands;

import org.serverct.mcpkg.dsl.AbstractCommand;
import org.serverct.mcpkg.dsl.CommandResult;

//输出
public class Echo extends AbstractCommand {
    public Echo(String cmd) {
        super(cmd);
    }

    @Override
    public CommandResult execute() {
        try {
            getEnvironment().sender.sendMessage(getArgs().poll());
        } catch (ArrayIndexOutOfBoundsException e) {
            return new CommandResult(false, e.getMessage());
        }
        return new CommandResult(true, "");
    }
}
