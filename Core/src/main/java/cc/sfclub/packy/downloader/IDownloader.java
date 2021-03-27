package cc.sfclub.packy.downloader;

import cc.sfclub.packy.session.OperationSession;
import org.jetbrains.annotations.ApiStatus;

import java.io.File;
import java.util.Set;
import java.util.function.Consumer;

@ApiStatus.AvailableSince("0.1.0")
public interface IDownloader {
    void downloadPackages(OperationSession session, Consumer<Set<TaskResult>> callback);

    TaskResult download(OperationSession session, String repo, String packageName, String version);

    void download(String url, Consumer<File> callback);
}
