package org.serverct.mcpkg.util;

import org.serverct.mcpkg.MCPkg;

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
