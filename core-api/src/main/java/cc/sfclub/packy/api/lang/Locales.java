package cc.sfclub.packy.api.lang;

import cc.sfclub.packy.api.IPacky;
import cc.sfclub.packy.util.Lazy;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

@ApiStatus.AvailableSince("0.1.0")
public class Locales {
    private static final Lazy<?, List<LocaleProvider>> LOCALES = Lazy.by(() -> {
        return ServiceLoader.load(LocaleProvider.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    });
    @Getter
    private static final Locales locale = new Locales();

    private Locales() {
    }

    @NotNull
    public String translate(String lang, String node) {
        return LOCALES.get().stream().map(e -> e.translate(lang, node)).filter(Objects::nonNull).findFirst().orElse("[Err] Cant translate following node: " + node);
    }

    @NotNull
    public String translate(String node) {
        return translate(IPacky.getInstance().getProperties().getLocale(), node);
    }
}
