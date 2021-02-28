package cc.sfclub.packy.impl;

import cc.sfclub.packy.I18N;
import cc.sfclub.packy.OperationSession;
import cc.sfclub.packy.Packy;
import cc.sfclub.packy.command.ICommandProcessor;
import cc.sfclub.packy.downloader.IDownloader;
import cc.sfclub.packy.impl.downloader.DownloaderImpl;
import cc.sfclub.packy.repo.IRepo;
import cc.sfclub.packy.repo.pkg.IPackageManager;
import cc.sfclub.packy.repo.pkg.Installer;
import cc.sfclub.packy.repo.pkg.validator.IValidator;
import cc.sfclub.packy.script.InstallScriptExecutor;
import cc.sfclub.packy.util.ConfigConsts;
import cc.sfclub.packy.util.MinecraftUtil;
import com.google.auto.service.AutoService;

import java.util.Map;
import java.util.UUID;

@AutoService(Packy.class)
public class PackyImpl implements Packy {
    private DownloaderImpl downloader;

    public PackyImpl() {
    }

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
