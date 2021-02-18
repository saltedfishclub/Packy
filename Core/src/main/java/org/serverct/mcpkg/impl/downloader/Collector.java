package org.serverct.mcpkg.impl.downloader;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class Collector<T> {
    private final int goal;
    private final Consumer<Set<T>> callback;
    private final Set<T> collector = new HashSet<>();

    public void collect(T t) {
        collector.add(t);
        if (collector.size() == goal) {
            callback.accept(collector);
        }
    }
}
