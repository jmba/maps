package org.wahlzeit.maptype;

import junit.framework.TestCase;
import org.wahlzeit.location.implementation.AbstractLocation;
import org.wahlzeit.location.implementation.GPSLocation;
import org.wahlzeit.maptype.implementation.CountryMap;

public class CountryMapTest extends TestCase {

	public void testCountryMapCorrect()  {
		boolean exceptionFired = false;

		try{
			CountryMap map = new CountryMap();
			map.setIdentCode("DE");
		} catch(Exception ex){
			exceptionFired = true;
		}
		assertFalse(exceptionFired);
	}

	public void testCountryMapInvalid()  {
		boolean exceptionFired = false;

		try{
			CountryMap map = new CountryMap();
			map.setIdentCode("DE2");
		} catch (Exception ex){
			exceptionFired = true;
		}

		assertTrue(exceptionFired);
	}

	public void locationTest(){
		CountryMap map = new CountryMap();
		String GPSString = "37.31917 N -122.04511 E";
		AbstractLocation gpsLocation = new GPSLocation(GPSString);
		map.setLocation(gpsLocation);

		assertTrue(map.getLocation().asString().equals(GPSString));
	}
}
