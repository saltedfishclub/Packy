package cc.sfclub.packy.impl.downloader;

import cc.sfclub.packy.downloader.TaskResult;
import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import cc.sfclub.packy.session.OperationSession;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DownloadTask implements Runnable {
    private final AbstractPackageInfo packageInfo;
    private final Collector<TaskResult> collector;
    private final OperationSession session;

    @Override
    public void run() {
        //collector.collect(downloader.download(session, packageInfo.getRepository(), packageInfo.getName(), packageInfo.getVersion()));
        packageInfo.download(collector::collect);
    }
}
