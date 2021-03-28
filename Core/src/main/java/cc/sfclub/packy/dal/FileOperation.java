package cc.sfclub.packy.dal;

import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.ApiStatus;

import java.io.File;

@ApiStatus.AvailableSince("0.1.0")
@Getter
@RequiredArgsConstructor
public final class FileOperation {
    private final AbstractPackageInfo operator;
    private final File operatedFile;
    private final Operation operation;
    private long time = System.currentTimeMillis();

    public enum Operation {
        READ, WHITE, DELETE, WHITE_NEW
    }
}
