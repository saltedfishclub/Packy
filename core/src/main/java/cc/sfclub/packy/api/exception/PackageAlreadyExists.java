package cc.sfclub.packy.api.exception;

import cc.sfclub.packy.api.pkg.IPackageVersion;

import java.util.List;

public class PackageAlreadyExists extends PackageConflictException{
    public PackageAlreadyExists(List<IPackageVersion> conflicts) {
        super(conflicts);
    }
}
