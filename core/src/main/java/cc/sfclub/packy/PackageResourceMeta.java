package cc.sfclub.packy;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PackageResourceMeta {
    private final String fileName;
    private final String hash;

}
