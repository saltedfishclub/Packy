package cc.sfclub.packy.impl;

import cc.sfclub.packy.provider.IRepoProvider;
import cc.sfclub.packy.repo.IRepo;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class RepoFinder {
    private static Map<String, IRepo> repository = new HashMap<>();
    private static boolean inited;

    public synchronized static Map<String, IRepo> findInstance() {
        if (!inited) {
            inited = true;
            return refresh();
        }
        return repository;
    }

    public synchronized static Map<String, IRepo> refresh() {
        for (IRepoProvider provider : ServiceLoader.load(IRepoProvider.class)) {
            provider.getRepoList().forEach(e -> {
                repository.put(e.getName(), e);
            });
        }
        return repository;
    }
}
