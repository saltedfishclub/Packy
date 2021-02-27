package cc.sfclub.packy.util;

import cc.sfclub.packy.MCPkg;

import java.util.ServiceLoader;

public class InstanceFinder {
    private static MCPkg cachedMCPkg;

    public synchronized static MCPkg findInstance() {
        if (cachedMCPkg == null) {
            for (MCPkg mpkg : ServiceLoader.load(MCPkg.class)) {
                cachedMCPkg = mpkg;
                return mpkg;
            }
        }
        return cachedMCPkg;
    }
}
