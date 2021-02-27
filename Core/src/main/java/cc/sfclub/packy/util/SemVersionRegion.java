package cc.sfclub.packy.util;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

@Getter
public class SemVersionRegion extends SimpleVersionRegion {
    private static final Pattern SEM_VERSION = Pattern.compile("^((\\d+\\.\\d+(\\.\\d+)?)|\\*)$");

    public SemVersionRegion(String lowest, String highest) {
        super(lowest, highest);
        if (!(checkSemVersion(lowest) && checkSemVersion(highest))) {
            // TODO if verbose output error msg
        } else {
            if (!"*".equals(lowest)) {
                this.lowest = new SemVersionBoard(lowest);
            }

            if (!"*".equals(highest)) {
                this.highest = new SemVersionBoard(highest);
            }
        }
    }

    public SemVersionRegion(String expr) {
        super(expr);
        if ("*".equals(expr) || "*~*".equals(expr)) {
            return;
        } else {
            String[] parts = expr.split("~");
            if (checkSemVersion(parts[0]) && checkSemVersion(parts[1])) {
                this.lowest = new SemVersionBoard(parts[0]);
                this.highest = new SemVersionBoard(parts[1]);
                return;
            }
        }
        // TODO if verbose output error msg
        throw new IllegalArgumentException("Illegal version format: " + expr);
    }

    public boolean isInRegion(String version) {
        if (checkSemVersion(version)) {
            return super.isInRegion(version);
        } else {
            return false;
        }
    }

    public static boolean checkSemVersion(String ver) {
        return SEM_VERSION.matcher(ver).matches();
    }

    public static int[] parseToInt(String ver) {
        if (checkSemVersion(ver)) {
            int[] version = new int[3];
            String[] parts = ver.split("\\.");

            for (int i = 0; i < parts.length; i++) {
                version[i] = Integer.parseInt(parts[i]);
            }
            if (parts.length == 2) {
                version[2] = -1;
            }

            return version;
        }

        throw new IllegalArgumentException("Illegal version format: " + ver);
    }

    private static class SemVersionBoard extends VersionBoard {
        private int[] version;

        public SemVersionBoard(@NotNull String version) {
            super(version);
        }

        @Override
        public boolean upper(String version) {
            if (this.all) {
                return true;
            }

            if (this.version == null) {
                this.version = SemVersionRegion.parseToInt(super.version);
            }

            int[] ver = SemVersionRegion.parseToInt(version);
            if (ver[0] < this.version[0]) {
                return false;
            } else if (ver[0] == this.version[0] && ver[1] < this.version[1]) {
                return false;
            } else if (ver[0] == this.version[0] && ver[1] == this.version[1] && ver[2] < this.version[2]) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public boolean lower(String version) {
            if (this.all) {
                return true;
            }

            if (this.version == null) {
                this.version = SemVersionRegion.parseToInt(super.version);
            }

            int[] ver = SemVersionRegion.parseToInt(version);
            if (ver[0] > this.version[0]) {
                return false;
            } else if (ver[0] == this.version[0] && ver[1] > this.version[1]) {
                return false;
            } else if (ver[0] == this.version[0] && ver[1] == this.version[1] && ver[2] > this.version[2]) {
                return false;
            } else {
                return true;
            }
        }
    }
}
