package org.wahlzeit.location.tests;

import junit.framework.TestCase;
import org.wahlzeit.location.implementation.GPSLocation;
import org.wahlzeit.location.implementation.MapCodeLocation;
import org.wahlzeit.location.LocationManager;


public class LocationManagerTest extends TestCase {

    public void testLocationManager() {
        String MapCodeString = "NLD 49.4V";
        String MapCodeString2 = "DC 18.JQZ";
        String GPSString = "37.31917 N -122.04511 E";

        MapCodeLocation location1 = LocationManager.getMapCodeLocationObject(MapCodeString);
        MapCodeLocation location2 = LocationManager.getMapCodeLocationObject(MapCodeString);
        GPSLocation location3 = LocationManager.getGPSLocationObject(GPSString);
        GPSLocation location4 = LocationManager.getGPSLocationObject(GPSString);

        assertTrue(location1.equals(location2));
        assertTrue(location3.equals(location4));
    }
}