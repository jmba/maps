package org.wahlzeit.location.Implementation;

import com.mapcode.Mapcode;
import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.UnknownMapcodeException;

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
		MapCodeLocation mapCodeLocation = new MapCodeLocation(mapCodeString);
		final Point p = MapcodeCodec.decode(mapCodeLocation.asString());
		
		GPSCoordinate latitude = new GPSCoordinate();	
		GPSCoordinate longitude = new GPSCoordinate();
		
		double latitudeDegree = p.getLatDeg();
		double longitudeDegree = p.getLonDeg();
		
		latitude.setDegree(latitudeDegree);
		longitude.setDegree(longitudeDegree);
		
		if(latitudeDegree >=0){
			latitude.setDirection("N");
		} else{
			latitude.setDirection("S");
		}
		
		if(longitudeDegree >=0){
			longitude.setDirection("E");
		}else{
			longitude.setDirection("W");
		}
		
		GPSLocation loc = new GPSLocation(latitude, longitude);
		
		return loc;
	}
	
	public String convertToGPSString(String mapCodeString) throws IllegalArgumentException, UnknownMapcodeException{
		return convertToGPSLocation(mapCodeString).asString();
	}
}
