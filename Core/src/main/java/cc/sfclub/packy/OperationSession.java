package cc.sfclub.packy;

import cc.sfclub.packy.command.ISender;
import cc.sfclub.packy.repo.data.local.PackageInfo;
import cc.sfclub.packy.script.ScriptEnv;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@RequiredArgsConstructor
public final class OperationSession {
    private final ISender sender;
    private final PackageInfo installingPackage;
    @Getter(AccessLevel.PRIVATE) //Hide getter
    public ScriptEnv scriptEnv;
    @Setter
    private OperationSession parent;
    private List<OperationSession> child;
}
