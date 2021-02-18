package org.serverct.mcpkg;

public class I18N {
    public Fails fails = new Fails();

    public static class Fails {
        public String Fail_to_Execute = "&cA exception occurred when executing the following commands:";
        public String Fail_to_Execute_Detail = " -&8&n %command &c%message";
        public String Fail_to_Execute_Location = "at line %line, package %package, stage: %type";
        public String ScriptExec_Type_Install = "Install";
        public String ScriptExec_Type_Uninstall = "Un-Install";
        public String ScriptExec_Type_PreInstall = "Pre-Install";
    }
}
