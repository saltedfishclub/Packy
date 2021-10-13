package cc.sfclub.packy.impl;

import cc.sfclub.packy.api.IPacky;
import cc.sfclub.packy.api.Locale;
import cc.sfclub.packy.api.PackyProperties;
import cc.sfclub.packy.api.dal.IStorageManager;
import cc.sfclub.packy.api.data.repo.IRepository;
import cc.sfclub.packy.api.multiplatform.IExecutor;
import cc.sfclub.packy.api.multiplatform.PlatformInfo;
import cc.sfclub.packy.api.pkg.IPackageManager;
import cc.sfclub.packy.api.providers.ICacheProvider;
import cc.sfclub.packy.api.tracker.ITracker;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PackyImpl implements IPacky {
    private final PackyProperties config;
    private final List<IRepository> repositories;
    private final ITracker actionTracker;
    private final ICacheProvider cacheManager;
    private final PlatformInfo platformInfo;
    private final IExecutor executor;
    private final Locale locale;
    private final IStorageManager storage;
    //
    private IPackageManager packageManager;
    {

    }
}
