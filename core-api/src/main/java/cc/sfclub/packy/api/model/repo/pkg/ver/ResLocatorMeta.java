package cc.sfclub.packy.api.model.repo.pkg.ver;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResLocatorMeta {
    private Type type;
    private String data;

    public enum Type {
        HTTP,
        PACKAGE_REF
    }
}
