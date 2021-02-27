package cc.sfclub.packy.util;

import cc.sfclub.packy.script.ScriptEnv;
import jdk.nashorn.api.scripting.ClassFilter;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.List;

public class ScriptEval {
    public static final SafeCF SAFE_CLASSFILTER = new SafeCF(null);
    private ScriptEngine scriptEngine = new NashornScriptEngineFactory().getScriptEngine(SAFE_CLASSFILTER);
    private SafeLevels overridingLevel;

    public ScriptEval(ScriptEnv environment) {
        scriptEngine.put("sender", environment.sender);
        scriptEngine.put("rootDir", environment.rootDir);
        scriptEngine.put("resources", environment.resources);
    }

    public ScriptEval(ScriptEnv environment, SafeLevels overridingLevel) {
        scriptEngine.put("sender", environment.sender);
        scriptEngine.put("rootDir", environment.rootDir);
        scriptEngine.put("resources", environment.resources);
        this.overridingLevel = overridingLevel;
        scriptEngine = new NashornScriptEngineFactory().getScriptEngine(new SafeCF(overridingLevel));
    }

    public Object eval(String strToEval) throws ScriptException {
        return scriptEngine.eval(strToEval);
    }

    public boolean boolEval(String strToEval) {
        try {
            return (boolean) scriptEngine.eval(strToEval);
        } catch (ScriptException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class SafeCF implements ClassFilter {
        private SafeLevels overridingLevel;

        public SafeCF(SafeLevels overridingLevel) {
            this.overridingLevel = overridingLevel;
        }

        public static final List<String> COMMON_ALLOWED = Arrays.asList(
                ""
        );
        public static final List<String> HIGH_ALLOWED = Arrays.asList(
                ""
        );

        @Override
        public boolean exposeToScripts(String s) {
            switch (overridingLevel != null ? overridingLevel : SafeLevels.valueOf(ConfigConsts.getConfig(ConfigConsts.INSTALLER_SAFE_LEVEL))) {
                case LOW:
                    if (!checkCommon(s)) {
                        return false;
                    }
                    break;
                case HIGH:
                    if (!checkCommon(s)) {
                        return false;
                    }
                    if (HIGH_ALLOWED.contains(s)) {
                        return true;
                    } else {
                        return false;
                    }
                case COMMON:
                    if (!checkCommon(s)) {
                        return false;
                    }
                    if (COMMON_ALLOWED.contains(s) || HIGH_ALLOWED.contains(s)) {
                        return true;
                    } else {
                        return false;
                    }
                case DISABLED:
                    return true;
                default:
                    System.err.println("Unknown safe level type: " + ConfigConsts.getConfig(ConfigConsts.INSTALLER_SAFE_LEVEL));
                    return false;
            }
            return false;
        }

        private boolean checkCommon(String s) {
            if (!s.startsWith("cc.sfclub.packy.impl.script.bindings")) {
                return false; //MUST REJECTED OR YOUR SERVER BOOM
            }
            try {
                Class.forName(s); //Make sure it's exist.
            } catch (ClassNotFoundException exception) {
                System.err.println("A script is attempting to access a non-exist class.");
                exception.printStackTrace();
                return false;
            }
            String[] s1 = s.split("\\.");
            boolean usingSafeCmd = s1[s1.length - 2].equals("safe"); // if in bindings.safe package.
            return false;
        }
    }
}
