package cc.sfclub.packy.impl;

import cc.sfclub.packy.Config;
import cc.sfclub.packy.I18N;
import cc.sfclub.packy.Packy;
import cc.sfclub.packy.dal.ICacheProvider;
import cc.sfclub.packy.dal.IFileTracker;
import cc.sfclub.packy.downloader.IDownloader;
import cc.sfclub.packy.impl.downloader.DownloaderImpl;
import cc.sfclub.packy.impl.repo.pkg.PackageManagerImpl;
import cc.sfclub.packy.impl.repo.pkg.validator.GPGValidatorImpl;
import cc.sfclub.packy.impl.script.ScriptExecutorImpl;
import cc.sfclub.packy.repo.IRepo;
import cc.sfclub.packy.repo.pkg.IPackageManager;
import cc.sfclub.packy.repo.pkg.validator.IValidator;
import cc.sfclub.packy.script.ScriptExecutor;
import cc.sfclub.packy.session.OperationSession;
import cc.sfclub.packy.util.ConfigConsts;
import cc.sfclub.packy.util.Platform;

import java.util.Map;
import java.util.UUID;

public class PackyImpl implements Packy {
    private DownloaderImpl downloader;
    private final Platform platform;
    private final ICacheProvider cache;
    private final ScriptExecutor scriptExecutor;
    private final IValidator validator;
    private final IPackageManager packageManager;
    private final Config config;
    private I18N i18n;

    public PackyImpl(Platform platform, ICacheProvider cache, I18N i18n, Config config) {
        this.platform = platform;
        this.cache = cache;
        this.i18n = i18n;
        this.config = config;
        scriptExecutor = new ScriptExecutorImpl();
        validator = new GPGValidatorImpl();
        packageManager = new PackageManagerImpl();
    }

    @Override
    public I18N getI18N() {
        return i18n;
    }

    @Override
    public IValidator getValidator() {
        return validator;
    }

    @Override
    public IDownloader getDownloader() {
        if (downloader == null) {
            downloader = new DownloaderImpl(Integer.parseInt(ConfigConsts.getConfig(ConfigConsts.DOWNLOAD_THREAD_NUMS)));
        }
        return downloader;
    }

    @Override
    public ScriptExecutor getScriptExecutor() {
        return scriptExecutor;
    }

    @Override
    public Map<String, IRepo> getRepos() {
        return RepoFinder.findInstance();
    }

    @Override
    public Map<UUID, OperationSession> getUsingOperationSessionsMap() {
        return null;
    }

    @Override
    public IPackageManager getPackageManager() {
        return packageManager;
    }

    @Override
    public Platform getPlatform() {
        return platform;
    }

    @Override
    public IFileTracker getFileTracker() {
        return null;
    }

    @Override
    public ICacheProvider getCache() {
        return cache;
    }

    @Override
    public Config getConfig() {
        return config;
    }
}
