package cc.sfclub.packy.api.data.repo.pkg.ver;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.jetbrains.annotations.Nullable;

@Data
public class ConfigurationMeta {

    private String id;

    @Nullable
    @SerializedName("name")
    private String prompt;

    @Nullable
    private String matches;

    @Nullable
    private String suggest;

    private boolean override;
}
