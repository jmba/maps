package org.wahlzeit.location.Implementation;

import java.security.InvalidParameterException;
import org.wahlzeit.location.ILocation;

/**
 * Abstract representation of a certain location. Derived
 * classes have to implement concrete implementations to
 * set and get a location in their own format.
 * @implements ILocation
 * @author jmba
 */
public abstract class AbstractLocation implements ILocation {
	
	public abstract String asString();
	protected abstract void doSetLocation(String location) throws InvalidParameterException;

	public void setLocation(String location) throws InvalidParameterException{
		if(location==null){
			throw new NullPointerException();
		}
		
		doSetLocation(location);
	}
}
