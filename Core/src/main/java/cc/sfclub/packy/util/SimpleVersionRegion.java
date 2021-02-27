package cc.sfclub.packy.util;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

@Getter
public class SimpleVersionRegion {
	private static final Pattern REGION = Pattern.compile("^(([\\u0000-\\uFFFF]+~[\\u0000-\\uFFFF]+)|\\*)$");

	protected VersionBoard lowest;
	protected VersionBoard highest;

	public SimpleVersionRegion(String lowest, String highest) {
		this.lowest = new VersionBoard(lowest);
		this.highest = new VersionBoard(highest);
	}

	public SimpleVersionRegion(String verReg) {
		if ("*".equals(verReg) || "*~*".equals(verReg)) {
			this.lowest = this.highest = new VersionBoard("*");
		} else {
			String[] parts = verReg.split("~");
			this.lowest = new VersionBoard(parts[0]);
			this.highest = new VersionBoard(parts[1]);
		}
	}

	public static SimpleVersionRegion parseVersionRegion(String verReg) {
		if (REGION.matcher(verReg).matches()) {
			if ("*".equals(verReg) || "*~*".equals(verReg)) {
				return new SimpleVersionRegion("*");
			} else {
				String[] parts = verReg.split(verReg);
				if (SemVersionRegion.checkSemVersion(parts[0]) && SemVersionRegion.checkSemVersion(parts[1])) {
					return new SemVersionRegion(parts[0], parts[1]);
				} else {
					return new SimpleVersionRegion(parts[0], parts[1]);
				}
			}
		} else {
			// TODO if verbose output error msg
			throw new IllegalArgumentException("Illegal version format: " + verReg);
		}
	}

	public boolean isInRegion(String version) {
		return this.lowest.upper(version) && this.highest.lower(version);
	}

	protected static class VersionBoard {
		@NotNull
		protected final String version;
		protected boolean all = false;

		public VersionBoard(@NotNull String version) {
			this.version = version;
			if ("*".equals(version)) {
				this.all = true;
			}
		}

		public boolean upper(String version) {
			return this.all || this.version.equals(version);
		}

		public boolean lower(String version) {
			return this.all || this.version.equals(version);
		}
	}
}
