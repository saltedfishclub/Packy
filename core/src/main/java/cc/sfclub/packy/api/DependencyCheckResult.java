package cc.sfclub.packy.api;

import cc.sfclub.packy.api.pkg.IPackageVersion;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DependencyCheckResult {
    private final List<IPackageVersion> conflicts;
    private final List<IPackageVersion> missingDeps;
}
