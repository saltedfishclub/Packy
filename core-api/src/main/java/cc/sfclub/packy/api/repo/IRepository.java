package cc.sfclub.packy.api.repo;

import cc.sfclub.packy.api.pkg.IPackageVersion;
import cc.sfclub.packy.api.pkg.IPackageResource;
import cc.sfclub.packy.api.PackageCoordinate;
import org.jetbrains.annotations.ApiStatus;

import java.util.Optional;

/**
 * A Repository, nobody cares where it comes from.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IRepository {
    String getName();
    IChannel<IPackageVersion> getRemoteChannel();
    IChannel<IPackageVersion> getLocalChannel();
    Optional<IPackageResource> getResourceByID(String key);
    Optional<IPackageResource> downloadResource(IPackageVersion meta, String key);
    Optional<IPackageVersion> fetchPackage(PackageCoordinate packageCoordinate);
    Optional<IPackageVersion> fetchPackage(String packageCoordinate);
}
