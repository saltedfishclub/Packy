package cc.sfclub.packy.api.repo.channel;

import cc.sfclub.packy.api.installer.InstallCondition;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
public class ChannelMeta {
    private transient String name;

    private List<String> ver = new ArrayList<>();

    private List<InstallCondition> requirement = new ArrayList<>();
}
