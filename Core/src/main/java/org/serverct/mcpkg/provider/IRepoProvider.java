package org.serverct.mcpkg.provider;

import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.repo.IRepo;

import java.util.List;

/**
 * 仓库列表提供者，应由插件/Adapter从文件，数据库处读取。
 * Provider 需要注册 Service
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepoProvider {
    /**
     * SPI 不能提供适当的加载时机。
     */
    void init();

    List<IRepo> getRepoList();
}
