package cc.sfclub.packy.api.data.repo.pkg.ver;

import cc.sfclub.packy.api.data.installer.InstallCondition;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class VersionMeta {

    @NotNull
    @SerializedName("deps")
    private List<InstallCondition> dependencies = new ArrayList<>();

    @NotNull
    @SerializedName("softdeps")
    private List<InstallCondition> optionalDependencies = new ArrayList<>();

    private List<InstallCondition> conflicts = new ArrayList<>();

    @NotNull
    private List<ConfigurationMeta> configurations = new ArrayList<>();

    @NotNull
    private List<VersionResource> resources = new ArrayList<>();
}
