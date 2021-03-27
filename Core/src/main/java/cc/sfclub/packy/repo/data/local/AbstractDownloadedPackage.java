package cc.sfclub.packy.repo.data.local;

import cc.sfclub.packy.repo.data.remote.PackageResource;
import cc.sfclub.packy.session.OperationSession;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * A installable Package
 */
@ApiStatus.AvailableSince("0.1.0")
public interface AbstractDownloadedPackage {
    @Nullable
    Sign getSign();

    File asFile();

    Map<InstallScriptType, String> getScripts();

    InstallResult install(OperationSession session);

    Map<String, PackageResource> getResources();

    AbstractPackageInfo getPackageInfo();

    enum InstallScriptType {
        PRE_INSTALL, INSTALL, UNINSTALL
    }
    @Getter
    abstract class Sign {
        protected String signer;
        protected File signature;
        protected abstract boolean isValid();
    }

    @Getter
    class InstallResult {
        private boolean success;
        private List<File> trackedFiles;
    }
}
