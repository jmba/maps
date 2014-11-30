package org.wahlzeit.location;

import org.wahlzeit.location.Implementation.GPSLocation;
import org.wahlzeit.location.Implementation.MapCodeLocation;

import java.security.InvalidParameterException;
import java.util.HashMap;

/**
 * Created by Johannes Bayerl on 25.11.14.
 *
 * Managerclass for locations. Implements sharing of GPS- and
 * MapCodeLocation- value-objects.
 */
public class LocationManager {

    private static HashMap<String,GPSLocation> gpsLocationPool = new HashMap<String,GPSLocation>();
    private static HashMap<String,MapCodeLocation> mapCodeLocationPool = new HashMap<String,MapCodeLocation>();

    /**
     * Factorymethod for GPSLocation-objects
     * @param locationString
     * @return GPSLocation
     */
    public static GPSLocation getGPSLocationObject(String locationString){
        GPSLocation location;

        if(gpsLocationPool.containsKey(locationString)){
            location = gpsLocationPool.get(locationString);
        } else{
            location = new GPSLocation(locationString);
            gpsLocationPool.put(locationString,location);
        }

        return location;
    }

    /**
     * Factorymethod for MapCodeLocation-objects
     * @param locationString
     * @return MapCodeLocation
     */
    public static MapCodeLocation getMapCodeLocationObject(String locationString){
        MapCodeLocation location;

        if(mapCodeLocationPool.containsKey(locationString)){
            location = mapCodeLocationPool.get(locationString);
        } else{
            location = new MapCodeLocation(locationString);
            mapCodeLocationPool.put(locationString,location);
        }

        return location;
    }

    public static HashMap<String,GPSLocation> getAllGPSLocations(){
        return gpsLocationPool;
    }

    public static HashMap<String,MapCodeLocation> getAllMapCodeLocations(){
        return mapCodeLocationPool;
    }
}