package cc.sfclub.packy.api;

import com.github.zafarkhaja.semver.Version;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
    @NotNull
    List<PackageCoordinate> depends();
    @NotNull
    List<PackageCoordinate> conflicts();
}
