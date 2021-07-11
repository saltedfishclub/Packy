package cc.sfclub.packy.api.exception;

import cc.sfclub.packy.api.pkg.IPackageVersion;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class PackageConflictException extends InstallException{
    public PackageConflictException(List<IPackageVersion> conflicts) {
        super("Encountered problem with these conflicting packages: "+ asList(conflicts));
    }
    private static String asList(List<IPackageVersion> v){
        StringJoiner sj = new StringJoiner("[","]",",");
        v.forEach(e->
                sj.add(e.getCoordinate().toString())
        );
        return sj.toString();
    }
}
