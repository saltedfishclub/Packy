package cc.sfclub.packy.command;

import cc.sfclub.packy.repo.data.local.PackageInfo;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

@SuppressWarnings("unused")
public class SimpleFallbacksSender implements ISender {
    private final ISender mainlySender;
    @Setter
    private List<ISender> fallback = new ArrayList<>();

    private SimpleFallbacksSender(ISender mainlySender) {
        this.mainlySender = mainlySender;
    }

    public static SimpleFallbacksSender of(ISender mainlySender) {
        SimpleFallbacksSender sfs = new SimpleFallbacksSender(mainlySender);
        ServiceLoader.load(IFallbackSender.class).iterator().forEachRemaining(sfs.fallback::add);
        return sfs;
    }

    @Override
    public void sendPackageList(List<PackageInfo> packages) {

    }

    @Override
    public void sendProgressBar(String task, int location) {

    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public boolean waitChoice() {
        return false;
    }
}
