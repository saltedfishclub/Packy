package org.serverct.mcpkg.downloader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.serverct.mcpkg.IMCPkg;
import org.serverct.mcpkg.util.StringConsts;

import java.io.File;

@ApiStatus.AvailableSince("0.1.0")
@Getter
@AllArgsConstructor
public final class TaskResult {
    private String repo;
    private String packageName;
    private boolean succeed;

    @Nullable
    public File getFileLocation() {
        if (!succeed) {
            return null;
        }
        return new File(IMCPkg.getImpl().getCacheDir() + "/" + repo + "/" + packageName + StringConsts.PKG_FILE_EXTENSION_NAME);
    }
}
