package org.serverct.mcpkg.util;

import jdk.nashorn.api.scripting.ClassFilter;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public enum ScriptEvalUtil {
    INSTANCE;
    private static ScriptEngine scriptEngine = new NashornScriptEngineFactory().getScriptEngine(new DenyAllCF());

    public Object eval(String strToEval) throws ScriptException {
        return scriptEngine.eval(strToEval);
    }

    private static class DenyAllCF implements ClassFilter {
        @Override
        public boolean exposeToScripts(String s) {
            return false;
        }
    }
}
