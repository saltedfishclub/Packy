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
    private final ISender sender;   // 结果反馈给谁?
    private final PackageInfo installingPackage; //这次会话安装的内容
    @Getter(AccessLevel.PRIVATE) //Hide getter
    public ScriptEnv scriptEnv;  //脚本运行时候的环境？
    @Setter
    private OperationSession parent; //这个Session派生何处？
    private List<OperationSession> child; //这个Session派生了哪些？

    public OperationSession fork(PackageInfo info) {
        OperationSession session = new OperationSession(sender, info);
        session.parent = this;
        child.add(session);
        return session;
    }
}
