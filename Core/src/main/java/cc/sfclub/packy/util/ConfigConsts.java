package cc.sfclub.packy.util;

public class ConfigConsts {
    public static final String INSTALLER_SAFE_LEVEL = "mcpkg.installer.safe.level";
    public static final String CACHE_DIR = "mcpkg.dir.cache";
    public static final String DOWNLOAD_THREAD_NUMS = "mcpkg.download.threadNum";

    private ConfigConsts() {
    }

    public static String getConfig(String key) {
        return System.getProperty(key);
    }
}
