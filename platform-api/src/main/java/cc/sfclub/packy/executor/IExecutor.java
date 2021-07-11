package cc.sfclub.packy.executor;

import cc.sfclub.packy.api.security.PackagePermission;
import cc.sfclub.packy.api.pkg.IPackageVersion;

public interface IExecutor {
    InstallResult install(IPackageVersion meta, String script, PackagePermission permission);
}
