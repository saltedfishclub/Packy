package cc.sfclub.packy.api.pkg;

import cc.sfclub.packy.api.PackageResourceMeta;
import cc.sfclub.packy.api.security.PackagePermission;
import cc.sfclub.packy.api.EnvironmentRequirement;
import cc.sfclub.packy.api.PackageConfiguration;
import cc.sfclub.packy.api.PackageCoordinate;
import cc.sfclub.packy.api.PackageType;
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

    List<PackageConfiguration> getConfigurations();

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
    default PackageCoordinate getCoordinate(){
        return new PackageCoordinate(getRepository(),getName(),getVersion());
    }
}
