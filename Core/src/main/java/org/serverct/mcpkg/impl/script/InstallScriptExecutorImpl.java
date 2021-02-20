package org.serverct.mcpkg.impl.script;

import org.serverct.mcpkg.MCPkg;
import org.serverct.mcpkg.OperationSession;
import org.serverct.mcpkg.repo.data.remote.PackageScript;
import org.serverct.mcpkg.script.InstallScriptExecutor;
import org.serverct.mcpkg.script.ScriptEnv;
import org.serverct.mcpkg.util.ScriptEval;

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
            session.getSender().sendMessage(String.format(MCPkg.getImpl().getI18N().fails.Fail_to_Execute, stageName));
            session.getSender().sendMessage(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean install(OperationSession session, PackageScript cmds) {
        return exec(session, cmds, MCPkg.getImpl().getI18N().scriptExecs.ScriptExec_Type_Install, InstallStage.INSTALL);
    }

    @Override
    public boolean uninstall(OperationSession session, PackageScript cmds) {
        return exec(session, cmds, MCPkg.getImpl().getI18N().scriptExecs.ScriptExec_Type_Uninstall, InstallStage.UN_INSTALL);
    }

    @Override
    public boolean preinstall(OperationSession session, PackageScript cmds) {
        return exec(session, cmds, MCPkg.getImpl().getI18N().scriptExecs.ScriptExec_Type_PreInstall, InstallStage.PRE_INSTALL);
    }

}
