package org.serverct.mcpkg.util;

import lombok.Getter;

@Getter
public class SemVersionRegion {
    private String lowest;
    private String highest;

    public SemVersionRegion(String lowest, String highest) {
        this.lowest = lowest;
        this.highest = highest;
    }

    public SemVersionRegion(String expr) {
        String[] s3 = expr.split("~");
        if (s3.length == 2) {
            lowest = s3[0];
            highest = s3[1];
        }
        //todo if verbose output error msg
    }

    public boolean isInRegion(String version) {
        return false;
        //todo
    }
}
