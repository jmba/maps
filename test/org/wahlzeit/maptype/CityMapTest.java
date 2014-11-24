package org.wahlzeit.maptype;

import junit.framework.TestCase;
import org.wahlzeit.location.Implementation.AbstractLocation;
import org.wahlzeit.location.Implementation.GPSLocation;
import org.wahlzeit.maptype.Implementation.CityMap;

public class CityMapTest extends TestCase {
	public void testCityMapCorrect()  {
		boolean exceptionFired = false;

		try{
			CityMap map = new CityMap();
			map.setIdentCode("ERH");
		} catch(Exception ex){
			exceptionFired = true;
		}
		assertFalse(exceptionFired);
	}

	public void testCityMapInvalid()  {
		boolean exceptionFired = false;

		try{
			CityMap map = new CityMap();
			map.setIdentCode("ERH2");
		} catch (Exception ex){
			exceptionFired = true;
		}

		assertTrue(exceptionFired);
	}

	public void locationTest(){
		CityMap map = new CityMap();
		String GPSString = "37.31917 N -122.04511 E";
		AbstractLocation gpsLocation = new GPSLocation(GPSString);
		map.setLocation(gpsLocation);

		assertTrue(map.getLocation().asString().equals(GPSString));
	}
}
