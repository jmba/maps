package org.wahlzeit.location.Implementation;

import com.mapcode.Mapcode;
import com.mapcode.MapcodeCodec;
import com.mapcode.Point;
import com.mapcode.Territory;
import com.mapcode.UnknownMapcodeException;


public class MapCodeLocation extends AbstractLocation {

	private Mapcode mapcodeCoordinate = null;
	
	public MapCodeLocation() {
		mapcodeCoordinate = new Mapcode("4J.RB", Territory.FRA);
	}
	
	@Override
	public String getLocation() {
		return mapcodeCoordinate.toString();
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
	public void asString() {
		// TODO Auto-generated method stub
		
	}
}
