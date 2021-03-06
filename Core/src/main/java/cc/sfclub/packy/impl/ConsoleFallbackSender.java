package cc.sfclub.packy.impl;

import cc.sfclub.packy.command.IFallbackSender;
import cc.sfclub.packy.repo.data.local.PackageInfo;
import com.google.auto.service.AutoService;

import java.util.List;

@AutoService(IFallbackSender.class)
public class ConsoleFallbackSender implements IFallbackSender {
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
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void sendPackageList(List<PackageInfo> packages) {
        System.err.println("Failed to send package list for original sender! Maybe he is offline or else??");
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
        System.err.println("Could not find original sender,choice auto rejected.");
        return false;
    }
}
