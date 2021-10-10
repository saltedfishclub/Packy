package cc.sfclub.packy.api;

import cc.sfclub.packy.util.Lazy;

import java.util.ServiceLoader;

public interface IPacky {
    static IPacky getInstance() {
        return InstFinder.FINDER.get();
    }

    class InstFinder {
        private static final Lazy<?, IPacky> FINDER = Lazy.by(() -> {
            return ServiceLoader.load(IPacky.class).iterator().next();
        });
    }
}
