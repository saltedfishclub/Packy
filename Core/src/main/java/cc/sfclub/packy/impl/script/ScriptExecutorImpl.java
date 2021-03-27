package cc.sfclub.packy.impl.script;

import cc.sfclub.packy.Packy;
import cc.sfclub.packy.script.ScriptEnv;
import cc.sfclub.packy.script.ScriptExecutor;
import cc.sfclub.packy.session.OperationSession;
import cc.sfclub.packy.util.SafeLevels;
import cc.sfclub.packy.util.ScriptEval;

import javax.script.ScriptException;

public class ScriptExecutorImpl implements ScriptExecutor {
    @Override
    public boolean execute(OperationSession session, String script, ScriptEnv env) {
        ScriptEnv scriptEnv = env;
        try {
            Object o = new ScriptEval(scriptEnv, SafeLevels.HIGH).eval(script);
            if (o instanceof Boolean) {
                return (boolean) o;
            }
        } catch (ScriptException e) {
            session.getSender().sendMessage(String.format(Packy.getImpl().getI18N().fails.Fail_to_Execute)); //todo
            session.getSender().sendMessage(e.getMessage());
        }
        return false;
    }
}
