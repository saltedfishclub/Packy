package cc.sfclub.packy.api.model.repo.channel;

import cc.sfclub.packy.api.model.installer.InstallCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class ChannelMeta {
    private List<String> ver = new ArrayList<>();

    private List<InstallCondition> requirement = new ArrayList<>();
}
