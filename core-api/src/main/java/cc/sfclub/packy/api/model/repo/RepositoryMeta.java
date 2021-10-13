package cc.sfclub.packy.api.model.repo;

import lombok.Data;

@Data
public class RepositoryMeta {
    private String name;
    private String arch;
    private String maintainer;
}
