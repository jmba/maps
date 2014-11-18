package org.wahlzeit.location.tests;

import junit.framework.TestCase;

import org.wahlzeit.location.Implementation.LocationConverter;
import com.mapcode.UnknownMapcodeException;

public class LocationConverterTest extends TestCase {
	
	public void testConvertToGPSLocation() {
		String MapCodeString = "NLD 49.4V";
		String GPSString = "52.376514 N 4.908542 E";
		
		LocationConverter converter = new LocationConverter();

		try {
			String convertedGPSString = converter.convertToGPSString(MapCodeString);
			assertTrue(convertedGPSString.equals(GPSString));
		} catch(UnknownMapcodeException e){
			e.printStackTrace();
		}
	}
	
	public void testConvertToGPSString()  {
		String MapCodeString = "NLD 49.4V";
		String GPSString = "52.376514 N 4.908542 E";
		
		LocationConverter converter = new LocationConverter();
		String ConvertedMapCodeString = converter.convertToMapCodeString(GPSString);
		assertTrue(ConvertedMapCodeString.equals(MapCodeString));
	}
}