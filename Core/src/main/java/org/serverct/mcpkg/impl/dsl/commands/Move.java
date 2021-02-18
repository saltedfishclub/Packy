package org.serverct.mcpkg.impl.dsl.commands;

import org.serverct.mcpkg.dsl.AbstractCommand;
import org.serverct.mcpkg.dsl.CommandResult;

//移动文件
public class Move extends AbstractCommand {
    public Move(String cmd) {
        super(cmd);
    }

    @Override
    public CommandResult execute() {
        return null; //todo 支持通配符
    }
}
