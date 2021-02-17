package org.serverct.mcpkg;

import org.serverct.mcpkg.command.ICommandProcessor;
import org.serverct.mcpkg.downloader.IDownloader;
import org.serverct.mcpkg.dsl.InstallScriptExecutor;
import org.serverct.mcpkg.repo.IRepo;
import org.serverct.mcpkg.repo.pkg.Installer;
import org.serverct.mcpkg.repo.pkg.validator.IValidator;

import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.UUID;

public interface IMCPkg {
    static IMCPkg getImpl() {
        for (IMCPkg imcPkg : ServiceLoader.load(IMCPkg.class)) {
            return imcPkg;
        }
        return null;
    }

    I18N getI18N();

    String getCacheDir();

    void loadConfig();

    Installer getInstaller();

    IValidator getValidator();

    IDownloader getDownloader();

    InstallScriptExecutor getScriptExecutor();

    List<IRepo> getRepos();

    ICommandProcessor getCommandProcessor();

    Map<UUID, OperationSession> getUsingOperationSessionsMap();
}
