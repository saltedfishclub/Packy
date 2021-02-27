package cc.sfclub.packy;

import cc.sfclub.packy.command.ISender;
import cc.sfclub.packy.repo.data.local.PackageInfo;

import java.util.List;
import java.util.Scanner;

public class ConsoleSender implements ISender {
    public static final ConsoleSender INSTANCE = new ConsoleSender();

    private ConsoleSender() {

    }

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
        System.out.println(ANSIConverter.convert(message));
    }

    @Override
    public boolean waitChoice() {
        sendMessage("Yes or No? >");
        Scanner s = new Scanner(System.in);
        return s.nextLine().toLowerCase().startsWith("y");
    }
}
