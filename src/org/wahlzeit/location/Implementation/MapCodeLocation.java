package org.wahlzeit.location.Implementation;

import com.mapcode.Mapcode;
import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.Territory;
import com.mapcode.UnknownMapcodeException;


public class MapCodeLocation extends AbstractLocation {

	private Mapcode mapcodeCoordinate = null;
	
	public MapCodeLocation() throws IllegalArgumentException, UnknownMapcodeException {
		mapcodeCoordinate = new Mapcode("4J.RB", Territory.FRA);
		String iso = mapcodeCoordinate.asInternationalISO();
		final String mapcode2 = "NLD 49.4V";
		final Point p = MapcodeCodec.decode(mapcode2);

		double lat = p.getLatDeg();
		double lon = p.getLonDeg();
	}

	
	@Override
	public void asString() {
		// TODO Auto-generated method stub
		
	}
}
