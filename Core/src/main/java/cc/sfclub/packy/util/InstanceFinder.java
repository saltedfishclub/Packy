package cc.sfclub.packy.util;

import cc.sfclub.packy.Packy;

import java.util.ServiceLoader;

public class InstanceFinder {
    private static Packy cachedMCPkg;

    public synchronized static Packy findInstance() {
        if (cachedMCPkg == null) {
            for (Packy mpkg : ServiceLoader.load(Packy.class)) {
                cachedMCPkg = mpkg;
                return mpkg;
            }
        }
        return cachedMCPkg;
    }

}
