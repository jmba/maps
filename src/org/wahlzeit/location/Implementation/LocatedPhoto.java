package org.wahlzeit.location.Implementation;

import org.wahlzeit.location.ILocation;
import org.wahlzeit.model.Photo;


public class LocatedPhoto extends Photo {
	
	private ILocation location;
	
	/**
	 * @methodtype get
	 * @return ILocation
	 */
	public ILocation getLocation() {
		return location;
	}

	/**
	 * @methodtype set
	 * @param location
	 */
	public void setLocation(ILocation location) {
		this.location = location;
	}
}