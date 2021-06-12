package cc.sfclub.packy.api.repo;

import cc.sfclub.packy.api.IPackageMeta;
import cc.sfclub.packy.api.IPackageResource;
import cc.sfclub.packy.api.PackageCoordinate;
import org.jetbrains.annotations.ApiStatus;

import java.util.Optional;

/**
 * A Repository, nobody cares where it comes from.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IRepository {
    String getName();
    IChannel getRemoteChannel();
    IChannel getLocalChannel();
    Optional<IPackageResource> getResourceByID(String key);
    Optional<IPackageResource> downloadResource(IPackageMeta meta, String key);
    Optional<IPackageMeta> fetchPackage(PackageCoordinate packageCoordinate);
    Optional<IPackageMeta> fetchPackage(String packageCoordinate);
}
