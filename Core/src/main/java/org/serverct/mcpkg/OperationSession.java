package org.serverct.mcpkg;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.serverct.mcpkg.command.ISender;
import org.serverct.mcpkg.repo.data.local.PackageInfo;

import java.util.List;

@Getter
@RequiredArgsConstructor
public final class OperationSession {
    private final ISender sender;
    private final List<PackageInfo> installingPackages;
    @Setter
    private OperationSession parent;
}
