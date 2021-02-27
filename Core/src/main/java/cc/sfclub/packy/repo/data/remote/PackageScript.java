package cc.sfclub.packy.repo.data.remote;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.io.File;
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
    private String preCheck; //file name,should pre-process.
    private String install;
    private String uninstall;

    public abstract void preprocess();

    public abstract Map<String, File> getCheckedResources();
}
