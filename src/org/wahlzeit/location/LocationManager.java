package org.wahlzeit.location;

import org.wahlzeit.location.implementation.GPSLocation;
import org.wahlzeit.location.implementation.MapCodeLocation;

import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.WeakHashMap;

/**
 * Created by Johannes Bayerl on 25.11.14.
 *
 * Managerclass for locations. Implements sharing of GPS- and
 * MapCodeLocation- value-objects.
 */
public class LocationManager {

    private static WeakHashMap<String,GPSLocation> gpsLocationPool = new WeakHashMap<String,GPSLocation>();
    private static WeakHashMap<String,MapCodeLocation> mapCodeLocationPool = new WeakHashMap<String,MapCodeLocation>();

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

    /**
     * Factorymethod for MapCode- and GPS- locations. It depends
     * on the input-string which Type returned.
     * @return
     */
    public static ILocation getILocation(String locationString){
        ILocation location = null;
        Boolean exceptionThrown = false;
        InvalidParameterException exceptionMapCode = null;

        try{
            location = getMapCodeLocationObject(locationString);
        }catch (InvalidParameterException ex){
            exceptionThrown = true;
            exceptionMapCode = ex;
        }

        if(exceptionThrown) {
            try {
                location = getGPSLocationObject(locationString);
            } catch (InvalidParameterException exceptionGPS) {
                exceptionGPS.printStackTrace();
                exceptionMapCode.printStackTrace();
            }
        }

        return location;
    }

    public static Collection<GPSLocation> getAllGPSLocations(){
        return gpsLocationPool.values();
    }

    public static Collection<MapCodeLocation> getAllMapCodeLocations(){
        return mapCodeLocationPool.values();
    }
}