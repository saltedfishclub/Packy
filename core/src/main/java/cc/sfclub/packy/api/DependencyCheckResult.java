package cc.sfclub.packy.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DependencyCheckResult {
    private final List<IPackageMeta> conflicts;
    private final List<IPackageMeta> missingDeps;
}
