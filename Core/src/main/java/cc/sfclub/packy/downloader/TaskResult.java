package cc.sfclub.packy.downloader;

import cc.sfclub.packy.repo.data.local.AbstractDownloadedPackage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.ApiStatus;

import java.io.File;

@ApiStatus.AvailableSince("0.1.0")
@Getter
@AllArgsConstructor
public final class TaskResult {
    private AbstractDownloadedPackage downloadedPackage;
    @Setter
    private Result result;

    public File getFileLocation() {
        //todo:
        return null;
    }

    public boolean isSucceed() {
        return result == Result.DOWNLOADED;
    }

    public enum Result {
        DOWNLOADED, NOT_FOUND, NOT_COMPATIBILITY, IOEXCEPTION, FAILED_TO_VERIFY_SIGN;
    }
}
