package cc.sfclub.packy.api.providers;

import cc.sfclub.packy.api.repo.IRepository;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

@ApiStatus.AvailableSince("0.2.0")
public interface IRepoProvider {
    List<IRepository> fetch();
}
