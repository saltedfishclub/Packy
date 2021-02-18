package org.serverct.mcpkg;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class CLI {
    public static final char COLOR_CHAR = '\u00A7';
    public static LineReader reader;
    private static Terminal terminal;

    private CLI() {
    }

    public static void main(String... args) throws IOException {
        final String banner = "Welcome back to MCPkg CLI! type `help` for help.";
        System.out.println(banner);
        terminal = TerminalBuilder.builder().jansi(true).build();
        reader = LineReaderBuilder.builder().terminal(terminal).appName("MCPkg CLI").build();
        while (true) {
            try {
                String l = reader.readLine("MCPkg > ");
                MCPkg.getImpl().getCommandProcessor().handle(l);
            } catch (UserInterruptException e) {
                System.out.println("Interrupted.");
            } catch (EndOfFileException e) {
                System.out.println("GoodBye.");
                return;
            }
        }
    }
}
