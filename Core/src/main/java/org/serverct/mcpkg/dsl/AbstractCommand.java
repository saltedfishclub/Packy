package org.serverct.mcpkg.dsl;

import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;

import java.util.LinkedList;
import java.util.Queue;

@ApiStatus.AvailableSince("0.1.0")
@Getter
public abstract class AbstractCommand {
    private String cmdName;
    private Queue<String> args = new LinkedList<>();

    public AbstractCommand(String cmd) {
        String[] s = cmd.split("\\.");
        if (s.length == 0) {
            cmdName = cmd;
            return;
        }
        for (String s1 : s) {
            args.offer(s1);
        }
    }

    public abstract CommandResult execute();
}
