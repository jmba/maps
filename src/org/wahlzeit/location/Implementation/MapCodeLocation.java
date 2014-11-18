package org.wahlzeit.location.Implementation;

import java.security.InvalidParameterException;

import com.mapcode.Mapcode;
import com.mapcode.Territory;
import com.mapcode.UnknownTerritoryException;

/**
 * Concrete implementation of an MapCode-location.
 * Example of the string representation: "NLD 49.4V"
 * @author jmba
 *
 */
public class MapCodeLocation extends AbstractLocation {

	private Mapcode mapcode = null;
	
	public MapCodeLocation(String location) {
		doSetLocation(location);
	}
	
	public MapCodeLocation(Mapcode mapcode){
		this.mapcode = mapcode;
	}
	
	public Mapcode getMapCode(){
		return mapcode;
	}
	
	@Override
	protected void doSetLocation(String location) throws InvalidParameterException {
		String[] locationArray = location.split(" ");

		String coordinate = locationArray[1];
		Territory teritory;
		try {
			teritory = Territory.fromString(locationArray[0]);
		} catch (UnknownTerritoryException e) {
			throw new InvalidParameterException(
					"MapcodeLocation.doSetLocation(" + location
							+ ") parameter invalid.");
		}
		mapcode = new Mapcode(coordinate, teritory);
	}

	
	@Override
	public String asString() {
		String mapCodeString = mapcode.getMapcode();
		String territoryString = mapcode.getTerritory().name();
		return territoryString+" "+mapCodeString;		
	} 
}
