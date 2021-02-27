package cc.sfclub.packy.provider;

import cc.sfclub.packy.I18N;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.AvailableSince("0.1.0")
public interface I18NProvider {
    void init();

    I18N getI18N();
}
