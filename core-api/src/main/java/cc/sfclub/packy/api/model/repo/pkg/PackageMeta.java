package cc.sfclub.packy.api.model.repo.pkg;

import cc.sfclub.packy.api.model.repo.channel.ChannelMeta;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This means a repository in Packy Specification.
 */
@Data
@EqualsAndHashCode
public class PackageMeta {
    private final String name;
    private final String description;

    @NotNull
    private final PackageType type = PackageType.NORMAL;

    @NotNull
    @SerializedName("repo_dir")
    private final String repoDir = ".packy_repo";

    @Nullable
    private final String url;

    @Nullable
    private final List<String> maintainers = new ArrayList<>();

    @Nullable
    private final List<String> provides = new ArrayList<>();

    @Nullable
    private final Map<String, ChannelMeta> channels = new HashMap<>();
}
