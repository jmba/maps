package org.wahlzeit.location.implementation;

import com.mapcode.Mapcode;
import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.UnknownMapcodeException;
import org.wahlzeit.location.LocationManager;

/**
 * Converter to get MapCodeLocation form GPS-string or
 * GPS-location from MapCodeString.
 * 
 * @author jmba
 *
 */
public class LocationConverter {
	
	public MapCodeLocation convertToMapCodeLocation(String GPSString){
		GPSLocation gpsLocation = new GPSLocation(GPSString);
		
		double latitude = gpsLocation.getLatitude().getDegree();
		double longitude = gpsLocation.getLongitude().getDegree();
		
		Mapcode mapcode = MapcodeCodec.encodeToShortest(latitude, longitude);
		MapCodeLocation mapcodeLocation = new MapCodeLocation(mapcode);
		
		return mapcodeLocation;
	}
	
	public String convertToMapCodeString(String GPSString){
			return convertToMapCodeLocation(GPSString).asString();
	}
	
	public GPSLocation convertToGPSLocation(String mapCodeString) throws IllegalArgumentException, UnknownMapcodeException{
		MapCodeLocation mapCodeLocation = LocationManager.getMapCodeLocationObject(mapCodeString);
		final Point p = MapcodeCodec.decode(mapCodeLocation.asString());

		String latitudeDirection = "";
		String longitudeDirection = "";
		double latitudeDegree = 0.0;
		double longitudeDegree = 0.0;

		latitudeDegree = p.getLatDeg();
		longitudeDegree = p.getLonDeg();

		if(latitudeDegree >=0){
			latitudeDirection="N";
		} else{
			latitudeDirection="S";
		}
		
		if(longitudeDegree >=0){
			longitudeDirection = "E";
		}else{
			longitudeDirection="W";
		}
		
		GPSLocation loc = LocationManager.getGPSLocationObject(latitudeDegree + " " + latitudeDirection + " " + longitudeDegree + " " + longitudeDirection);
		
		return loc;
	}
	
	public String convertToGPSString(String mapCodeString) throws IllegalArgumentException, UnknownMapcodeException{
		return convertToGPSLocation(mapCodeString).asString();
	}
}
