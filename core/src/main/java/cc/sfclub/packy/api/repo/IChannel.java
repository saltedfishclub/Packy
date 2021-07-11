package cc.sfclub.packy.api.repo;

import cc.sfclub.packy.api.security.PackagePermission;
import cc.sfclub.packy.api.pkg.IPackageVersion;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

/**
 * A Interface where other API fetches data.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IChannel<T extends IPackageVersion> {
    String name();
    String arch();
    List<T> fetchFor(String expr);
    PackagePermission defaultPackagePermissions();
    IRepository repository();
    boolean add(T packageVersion);
}
