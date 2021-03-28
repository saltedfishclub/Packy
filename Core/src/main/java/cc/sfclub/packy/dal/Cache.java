package cc.sfclub.packy.dal;

import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;

import java.io.File;

@ApiStatus.AvailableSince("0.1.0")
public abstract class Cache {
    @Getter
    private boolean expired = false;

    public abstract File asFile(String id);

    protected abstract void clean();
}
