package org.serverct.mcpkg.script;

import org.jetbrains.annotations.ApiStatus;
import org.serverct.mcpkg.command.ISender;

import java.io.File;
import java.util.Map;

/**
 * 脚本运行环境。同一个脚本会话下的每条命令都共享
 */
@ApiStatus.AvailableSince("0.1.0")
public class ScriptEnv {
    public String rootDir = ".";
    public ISender sender;

    //todo public String mutable packageName;
    public Map<String, File> resources;
}
