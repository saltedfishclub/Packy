package cc.sfclub.packy.api;

import cc.sfclub.packy.api.dal.IStorageManager;
import cc.sfclub.packy.api.multiplatform.IExecutor;
import cc.sfclub.packy.api.multiplatform.PlatformInfo;
import cc.sfclub.packy.api.providers.ICacheProvider;
import cc.sfclub.packy.api.repo.IRepository;
import cc.sfclub.packy.api.tracker.ITracker;
import cc.sfclub.packy.util.Lazy;

import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;

public interface IPacky {
    class InstanceFinder{
        private static final Lazy<?,IPacky> instanceFinder = Lazy.by(()->{
            return Optional.ofNullable(ServiceLoader.load(IPacky.class).iterator().next()).orElseThrow(()->new NullPointerException("Can't find a packy provider"));
        });   
    }
    public static IPacky getInstance(){
        return InstanceFinder.instanceFinder.get();
    }
    PackyProperties getConfig();
    List<IRepository> getRepositories();
    ITracker getActionTracker();
    ICacheProvider getCacheManager();
    PlatformInfo getPlatformInfo();
    IExecutor getExecutor();
    Locale getLocale();
    IStorageManager getStorage();
    
}
