package org.serverct.mcpkg.impl.dsl.commands;

import org.serverct.mcpkg.dsl.AbstractCommand;
import org.serverct.mcpkg.dsl.CommandResult;

//复制文件，要支持通配符
public class Copy extends AbstractCommand {
    public Copy(String cmd) {
        super(cmd);
    }

    @Override
    public CommandResult execute() {
        return null;
    }
}
