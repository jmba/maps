package org.wahlzeit.location.Implementation;

import java.security.InvalidParameterException;

import com.mapcode.Mapcode;
import com.mapcode.Territory;
import com.mapcode.UnknownTerritoryException;

/**
 * Concrete implementation of an MapCode-location.
 * Example of the string representation: "NLD 49.4V"
 * @author jmba
 * @type value
 */
public class MapCodeLocation extends AbstractLocation {

	private final Mapcode mapcode;
	
	public MapCodeLocation(String location) {
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
	
	public MapCodeLocation(Mapcode mapcode){
		this.mapcode = mapcode;
	}
	
	public Mapcode getMapCode(){
		return mapcode;
	}

	@Override
	public String asString() {
		String mapCodeString = mapcode.getMapcode();
		String territoryString = mapcode.getTerritory().name();
		return territoryString+" "+mapCodeString;		
	} 
}
