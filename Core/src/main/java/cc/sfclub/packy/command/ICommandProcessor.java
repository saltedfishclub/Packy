package cc.sfclub.packy.command;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.AvailableSince("0.1.0")
public interface ICommandProcessor {
    void handle(ISender sender, String... command);
}
