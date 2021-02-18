package org.serverct.mcpkg.repo.data.local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

@ApiStatus.AvailableSince("0.1.0")
@Getter
@AllArgsConstructor
public final class PackageInfo {
    private String name;
    private String repo;
    private String version;
    @Nullable
    private String mcVersion;
    private String arch;
    private String description;

    private long lastUpdated;
    private boolean gpgSigned;
    private String downloadUrl;

    public static PackageInfo parse(String expr) {
        //// TODO: 2021/2/18
        return null;
    }

    public static boolean checkCompatibility(PackageInfo info) {
        //// TODO: 2021/2/18
        return false;
    }

    public String getFullName() {
        return repo + "/" + name;
    }
}
