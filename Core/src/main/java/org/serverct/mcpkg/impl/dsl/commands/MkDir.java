package org.serverct.mcpkg.impl.dsl.commands;

import org.serverct.mcpkg.dsl.AbstractCommand;
import org.serverct.mcpkg.dsl.CommandResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//创建新的文件夹
public class MkDir extends AbstractCommand {
    public MkDir(String cmd) {
        super(cmd);
    }

    @Override
    public CommandResult execute() {
        try {
            Files.createDirectory(Paths.get(getArgs().poll()));
        } catch (IOException e) {
            return new CommandResult(false, e.getMessage());
        }
        return new CommandResult(true, "");
    }
}
