package cc.sfclub.packy;

import cc.sfclub.packy.dal.ICacheProvider;
import cc.sfclub.packy.dal.IFileTracker;
import cc.sfclub.packy.downloader.IDownloader;
import cc.sfclub.packy.repo.IRepo;
import cc.sfclub.packy.repo.pkg.IPackageManager;
import cc.sfclub.packy.repo.pkg.validator.IValidator;
import cc.sfclub.packy.script.ScriptExecutor;
import cc.sfclub.packy.session.OperationSession;
import cc.sfclub.packy.util.InstanceFinder;
import cc.sfclub.packy.util.MinecraftUtil;

import java.util.Map;
import java.util.UUID;

public interface Packy {
    static Packy getImpl() {
        return InstanceFinder.findInstance();
    }

    I18N getI18N();

    void loadConfig();

    IValidator getValidator();

    IDownloader getDownloader();

    ScriptExecutor getScriptExecutor();

    Map<String, IRepo> getRepos();

    Map<UUID, OperationSession> getUsingOperationSessionsMap();

    IPackageManager getPackageManager();

    MinecraftUtil getMinecraftUtil();//todo decoupling

    IFileTracker getFileTracker();

    ICacheProvider getCache();

    Config getConfig();
}
