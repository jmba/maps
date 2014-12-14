package org.wahlzeit.location.tests;

import org.wahlzeit.location.implementation.MapCodeLocation;

import junit.framework.TestCase;

public class MapCodeLocationTest extends TestCase {
	public void testMapCodeLocation()  {
		String MapCodeString = "NLD 49.4V";
		MapCodeLocation gpsLocation = new MapCodeLocation(MapCodeString);
		assertTrue(gpsLocation.asString().equals(MapCodeString));
	}
}
