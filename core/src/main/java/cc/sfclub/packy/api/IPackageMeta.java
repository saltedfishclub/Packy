package cc.sfclub.packy.api;

import cc.sfclub.packy.PackagePermission;
import cc.sfclub.packy.api.repo.IChannel;
import com.github.zafarkhaja.semver.Version;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

/**
 * Representing a package in the database.
 */
@ApiStatus.AvailableSince("0.2.0")
public interface IPackageMeta {
    String name();
    Version version();
    String description();
    String repository();
    boolean isLocal();
    PackagePermission getRequestedPermission();
    @Nullable
    List<String> provides();
    @NotNull
    List<PackageCoordinate> depends();
    @NotNull
    List<PackageCoordinate> conflicts();
    Optional<IPackageResource> fetchResource(String id);
    IChannel from();
}
