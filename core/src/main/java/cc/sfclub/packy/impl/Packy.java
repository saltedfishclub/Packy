package cc.sfclub.packy.impl;

import cc.sfclub.packy.PlatformInfo;
import cc.sfclub.packy.api.pkg.IPackageManager;
import cc.sfclub.packy.api.Locale;
import cc.sfclub.packy.api.PackyProperties;
import cc.sfclub.packy.api.dal.IStorageManager;
import cc.sfclub.packy.api.providers.ICacheProvider;
import cc.sfclub.packy.api.repo.IRepository;
import cc.sfclub.packy.api.tracker.ITracker;
import cc.sfclub.packy.executor.IExecutor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Packy {
    private final PackyProperties config;
    private final List<IRepository> repositories;
    private final ITracker actionTracker;
    private final ICacheProvider cacheManager;
    private final PlatformInfo platform;
    private final IExecutor executor;
    private final Locale locale;
    private final IStorageManager storage;
    //
    private IPackageManager packageManager;
    {

    }
}
