package cc.sfclub.packy.repo.pkg;

import cc.sfclub.packy.repo.data.local.PackageInfo;
import cc.sfclub.packy.session.OperationSession;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.AvailableSince("0.1.0")
public interface Installer {

    /**
     * 记得检查版本来判断是否是 update
     *
     * @param packageInfo
     * @param session
     * @return
     */
    boolean install(PackageInfo packageInfo, OperationSession session);
}
