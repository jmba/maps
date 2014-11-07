package org.wahlzeit.location.Implementation;

public class GPSLocation extends AbstractLocation {

	private GPSCoordinate longitude;
	private GPSCoordinate latitude;
	
	public GPSLocation(String location) {
		
	}
	
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
	protected void doSetLocation(String location) {
		// TODO Auto-generated method stub
	}

	@Override
	protected String doGetLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void asString() {
		// TODO Auto-generated method stub
	}
}
