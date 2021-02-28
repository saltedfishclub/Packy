package cc.sfclub.packy.impl.script;

import cc.sfclub.packy.OperationSession;
import cc.sfclub.packy.Packy;
import cc.sfclub.packy.repo.data.remote.PackageScript;
import cc.sfclub.packy.script.InstallScriptExecutor;
import cc.sfclub.packy.script.ScriptEnv;
import cc.sfclub.packy.util.ScriptEval;

import javax.script.ScriptException;

public class InstallScriptExecutorImpl implements InstallScriptExecutor {

    private boolean exec(OperationSession session, PackageScript cmds, String stageName, InstallStage stage) {
        ScriptEnv scriptEnv = session.scriptEnv;
        scriptEnv.resources = cmds.getCheckedResources();
        try {
            switch (stage) {
                case INSTALL:
                    Object o = new ScriptEval(scriptEnv).eval(cmds.getInstall());
                    if (o instanceof Boolean) {
                        return (boolean) o;
                    }
                    break;
                case UN_INSTALL:
                    Object a = new ScriptEval(scriptEnv).eval(cmds.getUninstall());
                    if (a instanceof Boolean) {
                        return (boolean) a;
                    }
                    break;
                case PRE_INSTALL:
                    Object z = new ScriptEval(scriptEnv).eval(cmds.getPreCheck());
                    if (z instanceof Boolean) {
                        return (boolean) z;
                    }
            }
        } catch (ScriptException e) {
            session.getSender().sendMessage(String.format(Packy.getImpl().getI18N().fails.Fail_to_Execute, stageName));
            session.getSender().sendMessage(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean install(OperationSession session, PackageScript cmds) {
        return exec(session, cmds, Packy.getImpl().getI18N().scriptExecs.ScriptExec_Type_Install, InstallStage.INSTALL);
    }

    @Override
    public boolean uninstall(OperationSession session, PackageScript cmds) {
        return exec(session, cmds, Packy.getImpl().getI18N().scriptExecs.ScriptExec_Type_Uninstall, InstallStage.UN_INSTALL);
    }

    @Override
    public boolean preinstall(OperationSession session, PackageScript cmds) {
        return exec(session, cmds, Packy.getImpl().getI18N().scriptExecs.ScriptExec_Type_PreInstall, InstallStage.PRE_INSTALL);
    }

}
