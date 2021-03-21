package cc.sfclub.packy.impl.downloader;

import cc.sfclub.packy.downloader.IDownloader;
import cc.sfclub.packy.downloader.TaskResult;
import cc.sfclub.packy.repo.data.local.PackageInfo;
import cc.sfclub.packy.session.OperationSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DownloadTask implements Runnable {
    private final PackageInfo packageInfo;
    private final Collector<TaskResult> collector;
    private final IDownloader downloader;
    private final OperationSession session;

    @Override
    public void run() {
        collector.collect(downloader.download(session, packageInfo.getRepo(), packageInfo.getName(), packageInfo.getVersion()));
    }
}
