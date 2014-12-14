package org.wahlzeit.location.tests;

import org.wahlzeit.location.implementation.AbstractLocation;
import org.wahlzeit.location.implementation.GPSLocation;

import junit.framework.TestCase;

public class GPSLocationTest extends TestCase {
	public void testGPSLocation()  {
		String GPSString = "37.31917 N -122.04511 E";
		AbstractLocation gpsLocation = new GPSLocation(GPSString);
		
		assertTrue(gpsLocation.asString().equals(GPSString));
	}
}
