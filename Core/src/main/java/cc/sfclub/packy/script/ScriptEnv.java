package cc.sfclub.packy.script;

import cc.sfclub.packy.command.ISender;
import org.jetbrains.annotations.ApiStatus;

import java.io.File;
import java.util.Map;

/**
 * 脚本运行环境。同一个脚本会话下的每条命令都共享
 * 记得修改 ScriptEval
 */
@ApiStatus.AvailableSince("0.1.0")
public class ScriptEnv {
    public String rootDir = ".";
    public ISender sender;

    //todo public String mutable packageName;
    public Map<String, File> resources;
}
