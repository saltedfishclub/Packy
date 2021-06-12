package cc.sfclub.packy.executor;

import cc.sfclub.packy.PackagePermission;
import cc.sfclub.packy.api.IPackageVersion;

public interface IExecutor {
    InstallResult install(IPackageVersion meta, String script, PackagePermission permission);
}
