package org.serverct.mcpkg.impl.dsl.commands;

import org.serverct.mcpkg.dsl.AbstractCommand;
import org.serverct.mcpkg.dsl.CommandResult;
import org.serverct.mcpkg.util.ScriptEvalUtil;

import javax.script.ScriptException;

//require js_expr
public class Require extends AbstractCommand {
    public Require(String cmd) {
        super(cmd);
    }

    @Override
    public CommandResult execute() {
        try {
            return new CommandResult((Boolean) ScriptEvalUtil.INSTANCE.eval(getArgs().poll()), "");
        } catch (ScriptException e) {
            return new CommandResult(false, e.getMessage());
        }
    }
}
