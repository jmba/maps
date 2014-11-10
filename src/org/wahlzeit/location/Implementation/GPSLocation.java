package org.wahlzeit.location.Implementation;

import java.security.InvalidParameterException;


public class GPSLocation extends AbstractLocation {

	private GPSCoordinate longitude;
	private GPSCoordinate latitude;
	
	public GPSLocation(String location) {
		doSetLocation(location);
	}
	
	public GPSLocation(GPSCoordinate latitude, GPSCoordinate longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public GPSCoordinate getLongitude() {
		return longitude;
	}

	public GPSCoordinate getLatitude() {
		return latitude;
	}
	
	public void setLatitude(GPSCoordinate latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(GPSCoordinate longitude) {
		this.longitude = longitude;
	}
	
	@Override
	protected void doSetLocation(String location) throws InvalidParameterException {
		String[] locationArray = location.split(" ");

		latitude = new GPSCoordinate();
		latitude.setDegree(Double.parseDouble(locationArray[0]));
		
		if(locationArray[1].equals("N")){
			latitude.setDirection("N");
		} else if(locationArray[1].equals("S")){
			latitude.setDirection("S");
		} else {
			throw new InvalidParameterException(
					"MapcodeLocation.doSetLocation(" + location
							+ ") parameter invalid.");
		}
		
		longitude = new GPSCoordinate();
		longitude.setDegree(Double.parseDouble(locationArray[2]));
		
		if(locationArray[3].equals("E")){
			longitude.setDirection("E");
		} else if(locationArray[3].equals("W")){
			longitude.setDirection("W");
		} else {
			throw new InvalidParameterException(
					"MapcodeLocation.doSetLocation(" + location
							+ ") parameter invalid.");
		}
	}

	@Override
	protected String doGetLocation() {
		return toString();
	}

	@Override
	public String asString() {
		return  latitude.getDegree() + " " +latitude.getDirection() +" "+ longitude.getDegree() + " " + longitude.getDirection();
	}
}
