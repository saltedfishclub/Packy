package cc.sfclub.packy.session;

import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import cc.sfclub.packy.script.ScriptEnv;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public final class OperationSession {
    private final ISender sender;   // 结果反馈给谁?
    private final List<AbstractPackageInfo> installingPackage; //这次会话安装的内容
    @Getter(AccessLevel.PRIVATE) //Hide getter
    public ScriptEnv scriptEnv;  //脚本运行时候的环境？
}
