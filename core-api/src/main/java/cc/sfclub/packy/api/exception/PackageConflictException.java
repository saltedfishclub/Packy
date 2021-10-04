package cc.sfclub.packy.api.exception;

import cc.sfclub.packy.api.EnvironmentRequirement;
import cc.sfclub.packy.api.pkg.IPackageVersion;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class PackageConflictException extends InstallException{
    public PackageConflictException(List<EnvironmentRequirement> conflicts) {
        super("Encountered problem with these conflicting packages: "+ asList(conflicts));
    }
    public PackageConflictException(List<IPackageVersion> v,boolean fuckTypeErasing){
        super("Encountered problem with this package:"+asList0(v));

    }
    private static String asList(List<EnvironmentRequirement> v){
        StringJoiner sj = new StringJoiner("[","]",",");
        v.forEach(e->
                sj.add(e.toString())
        );
        return sj.toString();
    }
    private static String asList0(List<IPackageVersion> v){
        StringJoiner sj = new StringJoiner("[","]",",");
        v.forEach(e->
                sj.add(e.getCoordinate().toString())
        );
        return sj.toString();
    }
}
