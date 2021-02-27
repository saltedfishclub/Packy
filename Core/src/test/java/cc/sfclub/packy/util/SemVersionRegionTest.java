package cc.sfclub.packy.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SemVersionRegionTest
{
	@Test
	public void checkSemVersion() {
		Assertions.assertFalse(SemVersionRegion.checkSemVersion(".1.2"));
		Assertions.assertFalse(SemVersionRegion.checkSemVersion("1.1.1.2"));
		Assertions.assertFalse(SemVersionRegion.checkSemVersion("A.1.2"));
		Assertions.assertFalse(SemVersionRegion.checkSemVersion("1.A1.2"));

		Assertions.assertTrue(SemVersionRegion.checkSemVersion("1.1.2"));
		Assertions.assertTrue(SemVersionRegion.checkSemVersion("1.1"));
	}
}
