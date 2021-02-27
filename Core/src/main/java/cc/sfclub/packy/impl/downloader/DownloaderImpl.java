package cc.sfclub.packy.impl.downloader;

import cc.sfclub.packy.MCPkg;
import cc.sfclub.packy.downloader.IDownloader;
import cc.sfclub.packy.downloader.TaskResult;
import cc.sfclub.packy.repo.data.local.PackageInfo;
import cc.sfclub.packy.util.ConfigConsts;
import com.github.kevinsawicki.http.HttpRequest;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.net.URI;
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
     * @param tasks
     * @param callback
     */
    @Override
    public void downloadPackages(Set<PackageInfo> tasks, Consumer<Set<TaskResult>> callback) {
        Collector<TaskResult> collector = new Collector<>(tasks.size(), callback); //Maybe fork-join pool?
        tasks.forEach(e -> {
            threadPool.submit(new DownloadTask(e, collector, this));
        });
    }

    @SneakyThrows
    @Override
    public TaskResult download(String repo, String packageName, @Nullable String version) {
        PackageInfo pack = PackageInfo.parse(version == null ? repo + "/" + packageName : repo + "/" + packageName + ":" + version);
        if (pack == null) {
            return new TaskResult(repo, packageName, version, TaskResult.Result.NOT_FOUND);
        }
        if (!PackageInfo.checkCompatibility(pack)) {
            return new TaskResult(repo, packageName, version, TaskResult.Result.NOT_COMPATIBILITY);
        }
        TaskResult result = new TaskResult(repo, packageName, version, TaskResult.Result.DOWNLOADED);
        try {
            int status = HttpRequest.get(new URI(pack.getDownloadUrl()).toURL()).followRedirects(true).receive(result.getFileLocation()).code();
            if (status != 200) {
                result.setResult(TaskResult.Result.NOT_FOUND);
            }
        } catch (HttpRequest.HttpRequestException exception) {
            exception.printStackTrace();
            result.setResult(TaskResult.Result.IOEXCEPTION);
        }
        if (pack.isGpgSigned() && !MCPkg.getImpl().getValidator().isSigned(result.getFileLocation())) {
            result.setResult(TaskResult.Result.FAILED_TO_VERIFY_SIGN);
        }
        return result;
    }

    @Override
    public void download(String url, Consumer<File> callback) {
        threadPool.submit(() -> {
            File cache = new File(ConfigConsts.getConfig(ConfigConsts.CACHE_DIR), "cache-" + UUID.randomUUID());
            int code = HttpRequest.get(url).followRedirects(true).receive(cache).code();
            if (code >= 400) { //error
                callback.accept(null);
            } else {
                callback.accept(cache);
            }
        });
    }
}
