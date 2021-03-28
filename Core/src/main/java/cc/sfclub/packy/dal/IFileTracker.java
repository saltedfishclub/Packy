package cc.sfclub.packy.dal;

import cc.sfclub.packy.repo.data.local.AbstractPackageInfo;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.AvailableSince("0.1.0")
public interface IFileTracker {
    void record(List<FileOperation> operations);

    List<FileOperation> fetch(AbstractPackageInfo packageInfo);
}
