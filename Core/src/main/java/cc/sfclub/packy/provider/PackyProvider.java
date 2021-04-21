package cc.sfclub.packy.provider;

import cc.sfclub.packy.Packy;
import org.jetbrains.annotations.ApiStatus;

/**
 * Provider 需要注册 Service
 * 提供一个 Packy. Provider 应该负责 Packy 的初始化工作，例如Platform的装载
 */
@ApiStatus.AvailableSince("0.1.0")
public interface PackyProvider {
    void init();

    Packy get();
}
