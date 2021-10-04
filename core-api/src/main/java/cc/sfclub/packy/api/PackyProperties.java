package cc.sfclub.packy.api;

import cc.sfclub.packy.api.security.PackagePermission;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;

/**
 * Config.
 */
@ApiStatus.AvailableSince("0.2.0")
@Builder
public class PackyProperties {
    public PackagePermission defaultPackagePermission_Install;
    public PackagePermission defaultPackagePermission_UnInstall;
    public PackagePermission defaultPackagePermission_Update;
}
