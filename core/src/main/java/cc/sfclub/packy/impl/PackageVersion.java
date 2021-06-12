package cc.sfclub.packy.impl;

import cc.sfclub.packy.PackageResourceMeta;
import cc.sfclub.packy.PackagePermission;
import cc.sfclub.packy.api.IPackageResource;
import cc.sfclub.packy.api.IPackageVersion;
import cc.sfclub.packy.api.PackageCoordinate;
import cc.sfclub.packy.api.repo.IChannel;
import com.github.zafarkhaja.semver.Version;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Builder
@Getter
public class PackageVersion implements IPackageVersion {
    private final String name;
    private final Version version;
    private final String description;
    private String repository;
    private boolean local;
    private PackagePermission requestedPermission;
    private List<String> provides;
    private List<PackageCoordinate> depends;
    private List<PackageCoordinate> conflicts;
    private Map<String, PackageResourceMeta> resources;
    private String fixer;
    private String agreement;
    private String installer;
    private String uninstaller;
    private final IChannel from;
    @Override
    public Optional<IPackageResource> fetchResource(String id) {
        return Optional.empty();
    }

    @Override
    public IChannel from() {
        return from;
    }
}
