package cc.sfclub.packy.impl;

import cc.sfclub.packy.api.data.repo.IChannel;
import cc.sfclub.packy.api.data.repo.IRepository;
import cc.sfclub.packy.api.pkg.IPackageVersion;
import cc.sfclub.packy.api.security.PackagePermission;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class SimpleLocalChannel<T extends IPackageVersion> implements IChannel {
    private IRepository repository;
    private String channelName;
    private String arch;
    private PackyImpl packy;
    private Class<T> classOfT;
    private PackagePermission defaultPkgPerm;
    @Override
    public String name() {
        return channelName;
    }

    @Override
    public String arch() {
        return arch;
    }

    @Override
    public List<T> fetchFor(String expr) {
        return packy.getStorage().byTypeAndName(classOfT,channelName).fetch(expr);
    }

    @Override
    public PackagePermission defaultPackagePermissions() {
        return defaultPkgPerm;
    }

    @Override
    public IRepository repository() {
        return repository;
    }

    @Override
    public boolean add(IPackageVersion packageVersion) {
        return packy.getStorage().byTypeAndName(classOfT,channelName).append(Collections.singletonList((T)packageVersion)); // possibly unsafe type-cast
    }
}
