package cc.sfclub.packy.executor;

import cc.sfclub.packy.PackagePermission;
import cc.sfclub.packy.api.IPackageMeta;

public interface IExecutor {
    InstallResult install(IPackageMeta meta, String script, PackagePermission permission);
}
