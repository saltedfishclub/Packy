package cc.sfclub.packy.api.client;

import cc.sfclub.packy.api.model.repo.RepositoryMeta;
import cc.sfclub.packy.api.model.repo.pkg.PackageMeta;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface IRepository {
    @RequestLine("GET /info")
    RepositoryMeta getInfo();

    @RequestLine("@GET /search?keyword={kw}")
    List<PackageMeta> searchFor(@Param("kw") String keywords);

    void updateKeyrings();

    void updateCache();
}
