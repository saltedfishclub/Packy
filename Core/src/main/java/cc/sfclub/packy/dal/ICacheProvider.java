package cc.sfclub.packy.dal;

import cc.sfclub.packy.util.Pair;
import org.jetbrains.annotations.ApiStatus;

import java.util.UUID;

@ApiStatus.AvailableSince("0.1.0")
public interface ICacheProvider {
    void init(String cacheRoot);

    Pair<UUID, Cache> allocate();

    Cache get(UUID ID);

}
