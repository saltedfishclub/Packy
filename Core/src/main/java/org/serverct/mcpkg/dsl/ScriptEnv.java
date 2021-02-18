package org.serverct.mcpkg.dsl;

import org.serverct.mcpkg.command.ISender;

import java.io.File;
import java.util.Map;

public class ScriptEnv {
    public String rootDir = ".";
    public ISender sender;
    public Map<String, File> resources;
}
