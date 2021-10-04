package cc.sfclub.packy.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PackageResourceMeta {
    private final String fileName;
    private final String hash;

}
