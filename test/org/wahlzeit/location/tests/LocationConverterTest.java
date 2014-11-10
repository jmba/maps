package org.wahlzeit.location.tests;

import junit.framework.TestCase;

import org.wahlzeit.location.Implementation.LocationConverter;
import com.mapcode.UnknownMapcodeException;

public class LocationConverterTest extends TestCase {
	
	public void testConvertToGPSLocation() throws IllegalArgumentException, UnknownMapcodeException  {
		String MapCodeString = "NLD 49.4V";
		String GPSString = "52.376514 N 4.908542 E";
		
		LocationConverter converter = new LocationConverter();
		String convertedGPSString = converter.convertToGPSString(MapCodeString);
		assertTrue(convertedGPSString.equals(GPSString));
	}
	
	public void testConvertToGPSString()  {
		String MapCodeString = "NLD 49.4V";
		String GPSString = "52.376514 N 4.908542 E";
		
		LocationConverter converter = new LocationConverter();
		String ConvertedMapCodeString = converter.convertToMapCodeString(GPSString);
		assertTrue(ConvertedMapCodeString.equals(MapCodeString));
	}
}