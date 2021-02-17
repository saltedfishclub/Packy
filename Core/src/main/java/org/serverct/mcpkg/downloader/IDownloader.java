package org.serverct.mcpkg.downloader;

import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.repo.data.local.PackageInfo;

import java.util.Set;
import java.util.function.Consumer;

@ApiStatus.AvailableSince("0.1.0")
public interface IDownloader {
    void downloadPackages(Set<PackageInfo> tasks, Consumer<Set<TaskResult>> callback);

    TaskResult download(String repo, String packageName);
}
