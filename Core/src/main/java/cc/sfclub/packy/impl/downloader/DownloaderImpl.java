package cc.sfclub.packy.impl.downloader;

import cc.sfclub.packy.downloader.IDownloader;
import cc.sfclub.packy.downloader.TaskResult;
import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import cc.sfclub.packy.session.OperationSession;
import cc.sfclub.packy.util.ConfigConsts;
import com.github.kevinsawicki.http.HttpRequest;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class DownloaderImpl implements IDownloader {
    private static ExecutorService threadPool;

    public DownloaderImpl(int threadsNum) {
        threadPool = Executors.newFixedThreadPool(threadsNum);
    }

    /**
     * 非堵塞 / NON-BLOCKING
     *
     * @param callback
     */
    @Override
    public void downloadPackages(OperationSession session, Consumer<Set<TaskResult>> callback) {
        List<AbstractPackageInfo> tasks = session.getInstallingPackage();
        Collector<TaskResult> collector = new Collector<>(tasks.size(), callback); //Maybe fork-join pool?
        tasks.forEach(e -> {
            threadPool.submit(new DownloadTask(e, collector, session));
        });
    }


    @Override
    public void download(String url, Consumer<File> callback) {
        threadPool.submit(() -> {
            File cache = new File(ConfigConsts.getConfig(ConfigConsts.CACHE_DIR), "cache-" + UUID.randomUUID());
            try {
                int code = HttpRequest.get(url).followRedirects(true).receive(cache).code();
                if (code >= 400) { //error
                    callback.accept(null);
                } else {
                    callback.accept(cache);
                }
            } catch (HttpRequest.HttpRequestException e) {
                callback.accept(null);
                e.printStackTrace();
            }
        });
    }
}
