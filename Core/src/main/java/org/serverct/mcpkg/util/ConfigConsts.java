package org.serverct.mcpkg.util;

public class ConfigConsts {
    public static final String CACHE_DIR = "mcpkg.dir.cache";
    public static final String DOWNLOAD_THREAD_NUMS = "mcpkg.download.threadNum";
    public String getConfig(String key) {
        return System.getProperty(key);
    }
}
