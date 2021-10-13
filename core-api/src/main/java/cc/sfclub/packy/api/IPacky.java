package cc.sfclub.packy.api;

import cc.sfclub.packy.api.model.installer.InstallCondition;
import cc.sfclub.packy.api.model.repo.pkg.ver.ResLocatorMeta;
import cc.sfclub.packy.internal.InstallConditionSerializer;
import cc.sfclub.packy.internal.ResLocatorMetaSerializer;
import cc.sfclub.packy.util.Lazy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ServiceLoader;

public interface IPacky {
    static IPacky getInstance() {
        return InstFinder.FINDER.get();
    }

    static Gson generalGsonSerializer() {
        return InstFinder.PREPARED_GSON.get();
    }

    // Implements knew that.
    PackyProperties getProperties();

    class InstFinder {
        private static final Lazy<?, IPacky> FINDER = Lazy.by(() -> {
            return ServiceLoader.load(IPacky.class).iterator().next();
        });
        private static final Lazy<?, Gson> PREPARED_GSON = Lazy.by(() -> {
            return new GsonBuilder()
                    .registerTypeAdapter(InstallCondition.class, new InstallConditionSerializer())
                    .registerTypeAdapter(ResLocatorMeta.class, new ResLocatorMetaSerializer())
                    .create();
        });
    }
}
