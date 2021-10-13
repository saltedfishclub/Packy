package cc.sfclub.packy.api.repo.pkg.ver;

import lombok.Data;

@Data
public class VersionResource {
    private String fileName;
    private ResLocatorMeta source;
    private String fileHash;
}
