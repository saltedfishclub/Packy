package cc.sfclub.packy.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PackageConfiguration {
    private String name;
    private String type;
    private String suggest;
}
