package cc.sfclub.packy.api;

import cc.sfclub.packy.api.security.PackagePermission;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InstallEnvironment {
    private PackagePermission permission;
}
