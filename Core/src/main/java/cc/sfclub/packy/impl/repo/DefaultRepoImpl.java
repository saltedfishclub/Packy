package cc.sfclub.packy.impl.repo;

import cc.sfclub.packy.Packy;
import cc.sfclub.packy.repo.IRepo;
import cc.sfclub.packy.repo.data.local.PackageInfo;
import cc.sfclub.packy.util.ConfigConsts;
import com.dieselpoint.norm.Database;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RequiredArgsConstructor
public class DefaultRepoImpl implements IRepo {
    private final String name;
    private final String repoUrl;
    private final transient byte[] lock = new byte[]{};
    private transient Database db;
    private transient long time = 0L;

    @Override
    public String getName() {
        return name;
    }

    private final File getDbLocation() {
        return new File(ConfigConsts.getConfig(ConfigConsts.HOME_DIR), "repo/" + name + ".db"); //todo init folder
    }

    @Override
    public List<PackageInfo> searchPackages(String keywords) {
        synchronized (lock) {
            return db.where("name GLOB ? OR description GLOB ?", keywords, keywords)
                    .results(PackageInfo.class);
        }
    }

    @Override
    public boolean tryRefresh(boolean force) {
        time = System.currentTimeMillis();
        // Download database and close connections
        Packy.getImpl().getDownloader().download(repoUrl, file -> {
            synchronized (lock) {
                // Close connection
                db.close();
                db = null;
                // Move to new location
                File backup = new File(getDbLocation().getName() + ".bak");
                getDbLocation().renameTo(new File(getDbLocation().getName() + ".bak"));
                try {
                    Files.move(file.toPath(), getDbLocation().toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Failed to refresh database by DefaultRepoImpl");
                    if (getDbLocation().exists()) {
                        getDbLocation().delete();
                    }
                    backup.renameTo(getDbLocation());
                }
                db = new Database();
                db.setJdbcUrl("jdbc:sqlite:" + getDbLocation().toString());
                db.setDriverClassName("org.sqlite.JDBC");
                // Refresh completed!
            }
        });
        return true;
    }
}
