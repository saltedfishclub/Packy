package org.serverct.mcpkg.impl.dsl.commands;

import org.serverct.mcpkg.dsl.AbstractCommand;
import org.serverct.mcpkg.dsl.CommandResult;

//解压文件 参数两个 ZIP文件资源/文件名 目的地
public class UnZIP extends AbstractCommand {
    public UnZIP(String cmd) {
        super(cmd);
    }

    @Override
    public CommandResult execute() {
        return null;
    }
}
