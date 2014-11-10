package org.wahlzeit.location.Implementation;

import java.security.InvalidParameterException;

import org.wahlzeit.location.ILocation;

public abstract class AbstractLocation implements ILocation {
	
	public abstract String asString();
	protected abstract void doSetLocation(String location) throws InvalidParameterException;
	protected abstract String doGetLocation();
	
	public void setLocation(String location) throws InvalidParameterException{
		if(location==null){
			throw new NullPointerException();
		}
		
		doSetLocation(location);
	}
}
