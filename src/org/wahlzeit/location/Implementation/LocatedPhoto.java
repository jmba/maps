package org.wahlzeit.location.implementation;

import org.wahlzeit.location.ILocation;
import org.wahlzeit.maptype.IRealAreaMapType;
import org.wahlzeit.model.Photo;


public class LocatedPhoto extends Photo {
	
	private ILocation location;
	private IRealAreaMapType mapTape;

	public static final String LOCATION = "location";

	/**
	 * @methodtype get
	 * @return
	 */
	public IRealAreaMapType getMapTape() {
		return mapTape;
	}

	/**
	 * @methodtype set
	 * @param mapTape
	 */
	public void setMapTape(IRealAreaMapType mapTape) {
		this.mapTape = mapTape;
	}

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