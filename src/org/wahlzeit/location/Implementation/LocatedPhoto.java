package org.wahlzeit.location.Implementation;

import org.wahlzeit.location.ILocation;
import org.wahlzeit.maptype.IMapType;
import org.wahlzeit.model.Photo;

import java.security.InvalidParameterException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LocatedPhoto extends Photo {
	
	private ILocation location;
	private IMapType mapTape;

	public static final String LOCATION = "location";

	/**
	 * @methodtype get
	 * @return
	 */
	public IMapType getMapTape() {
		return mapTape;
	}

	/**
	 * @methodtype set
	 * @param mapTape
	 */
	public void setMapTape(IMapType mapTape) {
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