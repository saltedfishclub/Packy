package cc.sfclub.packy.impl.repo;


import cc.sfclub.packy.provider.IRepoProvider;
import cc.sfclub.packy.repo.IRepo;
import cc.sfclub.packy.util.ConfigConsts;
import com.github.kevinsawicki.http.HttpRequest;
import com.google.auto.service.AutoService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AutoService(IRepoProvider.class)
public class DefaultRepoProvider implements IRepoProvider {
    private static final JsonParser jsonParser = new JsonParser();
    private static final Gson gson = new Gson();
    private final List<IRepo> repos = new ArrayList<>();

    @Override
    @SneakyThrows
    public void init() {
        Set<String> repos = new HashSet<>();
        File reposList = new File(ConfigConsts.getConfig(ConfigConsts.HOME_DIR), "repos.json");
        if (reposList.exists()) {
            JsonObject jo = jsonParser.parse(Files.newBufferedReader(reposList.toPath())).getAsJsonObject();
            if (jo.has("repos")) {
                jo.getAsJsonArray("repos").forEach(e -> repos.add(e.getAsString()));
            }
        }
        repos.forEach(e -> {
            RepoMetadata rm = gson.fromJson(HttpRequest.get(e).followRedirects(true).body(), RepoMetadata.class);
            if (rm.name != null && rm.file != null) {
                this.repos.add(new DefaultRepoImpl(rm.name, rm.file));
            }
        });
    }

    @Override
    public List<IRepo> getRepoList() {
        return repos;
    }

    public static class RepoMetadata {
        private String name;
        private String file;
    }
}
