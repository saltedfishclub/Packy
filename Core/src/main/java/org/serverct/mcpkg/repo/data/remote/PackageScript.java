package org.serverct.mcpkg.repo.data.remote;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;
import org.serverct.mcpkg.dsl.AbstractCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public abstract class PackageScript {
    private final Map<String, String> customElements = new HashMap<>();
    private String name;
    @Nullable
    private List<String> authors;
    private String version;
    private List<String> arch;
    @Nullable
    private Map<String, String> mcver;
    @Nullable
    private List<String> depends;
    @Nullable
    private List<String> conflicts;
    private String description;
    @Nullable
    private String javaVersion; //js expr
    private Map<String, PkgAttachment> files;
    private List<String> preCheck;
    private List<String> install;
    private List<String> uninstall;

    public abstract AbstractCommand getJavaVersion();

    public abstract List<AbstractCommand> getPreCheck();

    public abstract List<AbstractCommand> getInstall();

    public abstract List<AbstractCommand> getUninstall();
}
