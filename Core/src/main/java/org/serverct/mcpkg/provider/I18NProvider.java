package org.serverct.mcpkg.provider;

import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.I18N;

@ApiStatus.AvailableSince("0.1.0")
public interface I18NProvider {
    void init();

    I18N getI18N();
}
