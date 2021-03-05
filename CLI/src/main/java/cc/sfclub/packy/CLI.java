package cc.sfclub.packy;

import cc.sfclub.packy.script.ScriptEnv;
import cc.sfclub.packy.util.SafeLevels;
import cc.sfclub.packy.util.ScriptEval;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class CLI {
    private CLI() {
    }

    public static void main(String... args) throws Exception {
        // System.out.println(""+ANSIConverter.convert("&aaaaa&bbbbb&ccccc&ddddd&eeee&ffff"));
        // MCPkg.getImpl().getCommandProcessor().handle(ConsoleSender.INSTANCE,args);
        //Runtime.getRuntime().exec("kate").waitFor();
        if (args.length != 1) {
            System.err.println("arg: <js file>");
            return;
        }
        new ScriptEval(new ScriptEnv(), SafeLevels.HIGH).eval(Files.lines(Paths.get(args[0])).collect(Collectors.joining()));
    }
}
