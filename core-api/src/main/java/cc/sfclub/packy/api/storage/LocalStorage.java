package cc.sfclub.packy.api.storage;

import cc.sfclub.packy.util.Lazy;

import java.io.File;
import java.nio.file.Path;

public interface LocalStorage {
    Path getDataDir();

    default PairedKeyrings getPairedKeyrings() {
        return Lazies.KEYRINGS.get(getDataDir());
    }

    default Path getCacheDir() {
        return getDataDir().resolve("cache");
    }

    default Path getPackageDir() {
        return getDataDir().resolve("packages");
    }

    default File getDatabase() {
        throw new UnsupportedOperationException("todo");
    }

    class Lazies {
        private static final Lazy<Path, PairedKeyrings> KEYRINGS = Lazy.by(path -> {
            return new PairedKeyrings(path.resolve("keyrings/sec.kr").toFile(), path.resolve("keyrings/pub.kr").toFile());
        });
    }
}
