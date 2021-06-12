package cc.sfclub.packy.api;

import cc.sfclub.packy.PackageResourceMeta;
import cc.sfclub.packy.PackagePermission;
import cc.sfclub.packy.api.repo.IChannel;
import com.github.zafarkhaja.semver.Version;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Representing a package in the database.
 */
//todo refactor.
@ApiStatus.AvailableSince("0.2.0")
public interface IPackageVersion {
    String getName();
    Version getVersion();
    String getDescription();
    String getRepository();

    PackageType getType();
    List<EnvironmentRequirement> getEnv();
    List<PackageConfiguration> configurations();
    boolean isLocal();
    void setLocal(boolean y);
    PackagePermission getRequestedPermission();
    @Nullable
    List<String> getProvides();
    @NotNull
    List<PackageCoordinate> getDepends();
    @NotNull
    List<PackageCoordinate> getConflicts();
    Optional<IPackageResource> fetchResource(String id);
    Map<String, PackageResourceMeta> getResources();
    String getFixer();
    String getAgreement();
    String getInstaller();
    String getUninstaller();
    IChannel from();
}
