package cc.sfclub.packy.api.lang;

import org.jetbrains.annotations.Nullable;


public interface LocaleProvider {
    @Nullable
    String translate(String locale, String key);
}
