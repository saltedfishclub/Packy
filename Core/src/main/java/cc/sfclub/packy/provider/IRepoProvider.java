package cc.sfclub.packy.provider;

import cc.sfclub.packy.repo.IRepo;
import org.jetbrains.annotations.ApiStatus;

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
