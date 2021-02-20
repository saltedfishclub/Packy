package org.serverct.mcpkg;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.serverct.mcpkg.command.ISender;
import org.serverct.mcpkg.repo.data.local.PackageInfo;
import org.serverct.mcpkg.script.ScriptEnv;

import java.util.List;

@Getter
@RequiredArgsConstructor
public final class OperationSession {
    private final ISender sender;
    private final List<PackageInfo> installingPackages;
    @Getter(AccessLevel.PRIVATE) //Hide getter
    public ScriptEnv scriptEnv;
    @Setter
    private OperationSession parent;
}
