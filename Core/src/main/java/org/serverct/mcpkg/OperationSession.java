package org.serverct.mcpkg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.serverct.mcpkg.command.ISender;

@Getter
@AllArgsConstructor
public final class OperationSession {
    private ISender sender;
}
