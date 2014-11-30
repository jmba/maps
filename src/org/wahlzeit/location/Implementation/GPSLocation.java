package org.wahlzeit.location.Implementation;


import java.security.InvalidParameterException;

/**
 * Concrete implementation of an GPS-location.
 * Example of the string representation: "37.31917 N -122.04511 E"
 * @author Johannes Bayerl
 * @type value
 */
public class GPSLocation extends AbstractLocation {

	private final GPSCoordinate longitude;
	private final GPSCoordinate latitude;
	
	public GPSLocation(String location) {

		String[] locationArray = location.split(" ");
		String latitudeDirection = "";
		String longitudeDirection = "";
		double latitudeDegree = 0.0;
		double longitudeDegree = 0.0;

		latitudeDegree = Double.parseDouble(locationArray[0]);

		if(locationArray[1].equals("N")){
			latitudeDirection = "N";
		} else if(locationArray[1].equals("S")){
			latitudeDirection = "S";
		} else {
			throw new InvalidParameterException(
					"MapcodeLocation.doSetLocation(" + location
							+ ") parameter invalid.");
		}

		//longitude = new GPSCoordinate();
		longitudeDegree = Double.parseDouble(locationArray[2]);

		if(locationArray[3].equals("E")){
			longitudeDirection = "E";
		} else if(locationArray[3].equals("W")){
			longitudeDirection = "W";
		} else {
			throw new InvalidParameterException(
					"MapcodeLocation.doSetLocation(" + location
							+ ") parameter invalid.");
		}

		longitude = new GPSCoordinate(longitudeDirection,longitudeDegree);
		latitude = new GPSCoordinate(latitudeDirection,latitudeDegree);
	}

	public GPSCoordinate getLongitude() {
		return longitude;
	}

	public GPSCoordinate getLatitude() {
		return latitude;
	}

	@Override
	public String asString() {
		return  latitude.getDegree() + " " +latitude.getDirection() +" "+ longitude.getDegree() + " " + longitude.getDirection();
	}
}