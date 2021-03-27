package cc.sfclub.packy.repo.data.local;

import cc.sfclub.packy.downloader.TaskResult;
import cc.sfclub.packy.repo.IRepo;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

@ApiStatus.AvailableSince("0.1.0")
public interface AbstractPackageInfo {
    String getName();

    String getDescription();

    String getVersion();

    IRepo getRepository();

    @Nullable
    List<String> getDepends();

    @Nullable
    List<String> getConflicts();

    @Nullable
    AbstractDownloadedPackage getCachedPackage();

    /**
     * Cacheable.
     *
     * @param callback
     */
    void download(Consumer<TaskResult> callback);

    boolean isSigned();

    boolean isCompatible();

    default String asExpr() {
        return getRepository() + "/" + getName() + ":" + getVersion();
    }
}
