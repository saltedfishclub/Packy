package cc.sfclub.packy.api;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Locale {
    public String Package_Install_Conflict_NewerOrDuplicate = "Newer version or duplicate version exists!";
    public String Package_Install_Conflict_PackageAlreadyInstalled = "This package was already installed.";
}
