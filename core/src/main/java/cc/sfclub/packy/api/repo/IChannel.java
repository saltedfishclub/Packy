package cc.sfclub.packy.api.repo;

import cc.sfclub.packy.PackagePermission;
import cc.sfclub.packy.api.IPackageMeta;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

/**
 * A Interface where other API fetches data.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IChannel {
    String name();
    String arch();
    List<IPackageMeta> fetchFor(String expr);
    PackagePermission defaultPackagePermissions();
}
