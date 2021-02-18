package org.serverct.mcpkg.impl.dsl.commands;

import org.serverct.mcpkg.dsl.AbstractCommand;
import org.serverct.mcpkg.dsl.CommandResult;

//直接修改 env
public class Env extends AbstractCommand {
    public Env(String cmd) {
        super(cmd);
    }

    @Override
    public CommandResult execute() {
        return null;
    }
}
