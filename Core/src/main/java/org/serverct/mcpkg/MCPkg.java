package org.serverct.mcpkg;

import org.serverct.mcpkg.command.ICommandProcessor;
import org.serverct.mcpkg.downloader.IDownloader;
import org.serverct.mcpkg.repo.IRepo;
import org.serverct.mcpkg.repo.pkg.IPackageManager;
import org.serverct.mcpkg.repo.pkg.Installer;
import org.serverct.mcpkg.repo.pkg.validator.IValidator;
import org.serverct.mcpkg.script.InstallScriptExecutor;
import org.serverct.mcpkg.util.InstanceFinder;
import org.serverct.mcpkg.util.MinecraftUtil;

import java.util.Map;
import java.util.UUID;

public interface MCPkg {
    static MCPkg getImpl() {
        return InstanceFinder.findInstance();
    }

    I18N getI18N();

    String getCacheDir();

    void loadConfig();

    Installer getInstaller();

    IValidator getValidator();

    IDownloader getDownloader();

    InstallScriptExecutor getScriptExecutor();

    Map<String, IRepo> getRepos();

    ICommandProcessor getCommandProcessor();

    Map<UUID, OperationSession> getUsingOperationSessionsMap();

    IPackageManager getPackageManager();

    MinecraftUtil getMinecraftUtil();
}
