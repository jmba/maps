package org.wahlzeit.location.Implementation;

public class GPSLocation extends AbstractLocation {

	private GPSCoordinate longitude;
	private GPSCoordinate latitude;
	
	
	public GPSCoordinate getLongitude() {
		return longitude;
	}

	public void setLongitude(GPSCoordinate longitude) {
		this.longitude = longitude;
	}

	public GPSCoordinate getLatitude() {
		return latitude;
	}

	public void setLatitude(GPSCoordinate latitude) {
		this.latitude = latitude;
	}

	@Override
	public void asString() {
		// TODO Auto-generated method stub
	}
}
