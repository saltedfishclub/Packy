package cc.sfclub.packy.util;

import cc.sfclub.packy.Packy;
import cc.sfclub.packy.provider.PackyProvider;

import java.util.ServiceLoader;

public class InstanceFinder {
    private static Packy cachedMCPkg;

    public synchronized static Packy findInstance() {
        if (cachedMCPkg == null) {
            for (PackyProvider mpkg : ServiceLoader.load(PackyProvider.class)) {
                mpkg.init();
                cachedMCPkg = mpkg.get();
                return cachedMCPkg;
            }
        }
        return cachedMCPkg;
    }

}
