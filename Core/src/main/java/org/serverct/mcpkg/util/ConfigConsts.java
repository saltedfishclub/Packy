package org.serverct.mcpkg.util;

public class ConfigConsts {
    public static final String CACHE_DIR = "mcpkg.dir.cache";

    public String getConfig(String key) {
        return System.getProperty(key);
    }
}
