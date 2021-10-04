package cc.sfclub.packy.api;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Locale {
    public String Package_Install_Conflict_NewerOrDuplicate = "Newer version or duplicate version exists!";
    public String Package_Install_Conflict_PackageAlreadyInstalled = "This package was already installed.";
    public String Package_Should_Be_Local = "Package must be local.";
    public String Package_Meta_UnInstaller_Missing = "This package doesn't have a uninstaller,whoa!";
}
