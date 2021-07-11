package cc.sfclub.packy.api.exception;

import cc.sfclub.packy.api.EnvironmentRequirement;

public class EnvironmentNotCompatible extends InstallException{
    protected EnvironmentNotCompatible(EnvironmentRequirement r) {
        super(r.toString());
    }
}
