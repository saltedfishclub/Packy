package org.serverct.mcpkg.impl.dsl;

import org.serverct.mcpkg.OperationSession;
import org.serverct.mcpkg.dsl.InstallScriptExecutor;
import org.serverct.mcpkg.repo.data.remote.PackageScript;

public class InstallScriptExecutorImpl implements InstallScriptExecutor {

//    private boolean exec(OperationSession session, PackageScript pkg, String stage) {
//        int line = 0;
//        ScriptEnv env = new ScriptEnv();
//        for (AbstractCommand cmd : pkg.getInstall()) {
//            cmd.setEnvironment(env);
//            String cachedArgs = Arrays.toString(cmd.getArgs().toArray());
//            line++;
//            CommandResult result;
//            try {
//                result = cmd.execute();
//            } catch (Exception e) {
//                result = new CommandResult(false, e.getMessage());
//            }
//            if (!result.isSucceed()) {
//                session.getSender().sendMessage(MCPkg.getImpl().getI18N().fails.Fail_to_Execute);
//                session.getSender().sendMessage(MCPkg.getImpl().getI18N().fails.Fail_to_Execute_Detail
//                        .replaceAll("%command", cmd.getCmdName() + " " + cachedArgs)
//                        .replaceAll("%message", result.getMessage())
//                        .replaceAll("%type", stage));
//                session.getSender().sendMessage(MCPkg.getImpl().getI18N().fails.Fail_to_Execute_Location);
//            }
//        }
//        return true;///
//    }

    @Override
    public boolean install(OperationSession session, PackageScript cmds) {
//        return exec(session, cmds, MCPkg.getImpl().getI18N().scriptExecs.ScriptExec_Type_Install);
        return false;
    }

    @Override
    public boolean uninstall(OperationSession session, PackageScript cmds) {
//        return exec(session, cmds, MCPkg.getImpl().getI18N().scriptExecs.ScriptExec_Type_Uninstall);
        return false;
    }

    @Override
    public boolean preinstall(OperationSession session, PackageScript cmds) {
//        return exec(session, cmds, MCPkg.getImpl().getI18N().scriptExecs.ScriptExec_Type_PreInstall);
        return false;
    }

}
