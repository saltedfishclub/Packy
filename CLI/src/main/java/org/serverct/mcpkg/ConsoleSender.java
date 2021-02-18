package org.serverct.mcpkg;

import org.serverct.mcpkg.command.ISender;
import org.serverct.mcpkg.repo.data.local.PackageInfo;

import java.util.List;

public class ConsoleSender implements ISender {
    private static String generateProgressbar(int loc) {
        assert loc >= 0;
        assert loc <= 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i != loc; i++) {
            sb.append("======");
        }
        if (loc < 10) {
            for (int i = 0; i != (10 - loc); i++) {
                sb.append("------");
            }
        }
        return sb.toString();
    }

    @Override
    public void sendPackageList(List<PackageInfo> packages) {

    }

    @Override
    public void sendProgressBar(String task, int location) {
        System.out.println(task + " " + location * 10 + "% [" + generateProgressbar(location) + "]");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }

    @Override
    public boolean waitChoice() {
        return CLI.reader.readLine(" Yes or No? > ").toLowerCase().startsWith("y");
    }
}
