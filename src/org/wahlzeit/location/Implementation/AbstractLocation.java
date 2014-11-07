package org.wahlzeit.location.Implementation;

import org.wahlzeit.location.ILocation;

public abstract class AbstractLocation implements ILocation {
	
	protected String location = "";
	
	protected abstract void asString();
	protected abstract void doSetLocation(String location);
	protected abstract String doGetLocation();
	
	public void setLocation(String location){
		doSetLocation(location);
	}
	
	public String getLocation(){
		return location;
	}
}
