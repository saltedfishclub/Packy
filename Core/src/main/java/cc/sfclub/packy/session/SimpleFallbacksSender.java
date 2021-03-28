package cc.sfclub.packy.session;

import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class SimpleFallbacksSender implements ISender {
    private final ISender mainlySender;
    @Setter
    private List<IFallbackSender> fallback = new ArrayList<>();

    private SimpleFallbacksSender(ISender mainlySender) {
        this.mainlySender = mainlySender;
    }

    public static SimpleFallbacksSender of(ISender mainlySender) {
        SimpleFallbacksSender sfs = new SimpleFallbacksSender(mainlySender);
        ServiceLoader.load(IFallbackSender.class).iterator().forEachRemaining(sfs.fallback::add);
        return sfs;
    }

    @Override
    public boolean isAvailable() {
        return true; //Always true,
    }

    @Override
    public void sendPackageList(List<AbstractPackageInfo> packages) {
        if (mainlySender.isAvailable()) {
            mainlySender.sendPackageList(packages);
        } else {
            fallback.stream().filter(ISender::isAvailable).forEach(e -> e.sendPackageList(packages));
        }
    }

    @Override
    public void sendProgressBar(String task, int location) {
        if (mainlySender.isAvailable()) {
            mainlySender.sendProgressBar(task, location);
        } else {
            fallback.stream().filter(ISender::isAvailable).forEach(e -> e.sendProgressBar(task, location));
        }
    }

    @Override
    public void sendMessage(String message) {
        if (mainlySender.isAvailable()) {
            mainlySender.sendMessage(message);
        } else {
            fallback.stream().filter(ISender::isAvailable).forEach(e -> e.sendMessage(message));
        }
    }

    @Override
    public void waitChoice(Consumer<Choice> callback) {
        if (mainlySender.isAvailable()) {
            mainlySender.waitChoice(callback);
        } else {
            Optional<IFallbackSender> sender = fallback.stream().filter(ISender::isAvailable).findFirst();
            if (sender.isPresent()) {
                sender.get().waitChoice(callback);
            } else {
                callback.accept(Choice.TIMEOUT);
            }
        }
    }
}
