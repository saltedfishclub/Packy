package org.serverct.mcpkg.impl.downloader;

import lombok.RequiredArgsConstructor;
import org.serverct.mcpkg.downloader.IDownloader;
import org.serverct.mcpkg.downloader.TaskResult;
import org.serverct.mcpkg.repo.data.local.PackageInfo;

@RequiredArgsConstructor
public class DownloadTask implements Runnable {
    private final PackageInfo packageInfo;
    private final Collector<TaskResult> collector;
    private final IDownloader downloader;

    @Override
    public void run() {
        collector.collect(downloader.download(packageInfo.getRepo(), packageInfo.getName(), packageInfo.getVersion()));
    }
}
