package org.serverct.mcpkg.repo.data.local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.AvailableSince("0.1.0")
@Getter
@AllArgsConstructor
public final class PackageInfo {
    private String name;
    private String repo;
    private String version;
    private String description;

    private long lastUpdated;
    private boolean gpgSigned;
    private String downloadUrl;

    public String getFullName() {
        return repo + "/" + name;
    }
}
