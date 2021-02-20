package org.serverct.mcpkg.impl;

import com.google.auto.service.AutoService;
import org.serverct.mcpkg.I18N;
import org.serverct.mcpkg.MCPkg;
import org.serverct.mcpkg.OperationSession;
import org.serverct.mcpkg.command.ICommandProcessor;
import org.serverct.mcpkg.downloader.IDownloader;
import org.serverct.mcpkg.impl.downloader.DownloaderImpl;
import org.serverct.mcpkg.repo.IRepo;
import org.serverct.mcpkg.repo.pkg.IPackageManager;
import org.serverct.mcpkg.repo.pkg.Installer;
import org.serverct.mcpkg.repo.pkg.validator.IValidator;
import org.serverct.mcpkg.script.InstallScriptExecutor;
import org.serverct.mcpkg.util.ConfigConsts;
import org.serverct.mcpkg.util.MinecraftUtil;

import java.util.Map;
import java.util.UUID;

@AutoService(MCPkg.class)
public class MCPKgImpl implements MCPkg {
    private DownloaderImpl downloader;
    
    @Override
    public I18N getI18N() {
        return null;
    }

    @Override
    public String getCacheDir() {
        return null;
    }

    @Override
    public void loadConfig() {

    }

    @Override
    public Installer getInstaller() {
        return null;
    }

    @Override
    public IValidator getValidator() {
        return null;
    }

    @Override
    public IDownloader getDownloader() {
        if (downloader == null) {
            downloader = new DownloaderImpl(Integer.parseInt(ConfigConsts.getConfig(ConfigConsts.DOWNLOAD_THREAD_NUMS)));
        }
        return downloader;
    }

    @Override
    public InstallScriptExecutor getScriptExecutor() {
        return null;
    }

    @Override
    public Map<String, IRepo> getRepos() {
        return null;
    }

    @Override
    public ICommandProcessor getCommandProcessor() {
        return null;
    }

    @Override
    public Map<UUID, OperationSession> getUsingOperationSessionsMap() {
        return null;
    }

    @Override
    public IPackageManager getPackageManager() {
        return null;
    }

    @Override
    public MinecraftUtil getMinecraftUtil() {
        return null;
    }
}
