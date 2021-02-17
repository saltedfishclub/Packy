package org.serverct.mcpkg.dsl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.command.ISender;

@ApiStatus.AvailableSince("0.1.0")
@AllArgsConstructor
@Data
public final class CommandResult {
    private boolean succeed;
    private String message;

    public boolean throwOrSucceed(ISender sender) {
        throw new UnsupportedOperationException("todo");
    }
}
