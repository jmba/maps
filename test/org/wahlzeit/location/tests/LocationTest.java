package org.wahlzeit.location.tests;

import org.wahlzeit.location.Implementation.MapCodeLocation;

import com.mapcode.UnknownMapcodeException;

import junit.framework.*;

public class LocationTest extends TestCase {
	/**
	 * @throws UnknownMapcodeException 
	 * @throws IllegalArgumentException 
	 * 
	 */
	public void testHasRights() throws IllegalArgumentException, UnknownMapcodeException {
			MapCodeLocation mcl = new MapCodeLocation();
			String bla = mcl.getLocation();
			System.out.println("   "+bla);
	}
}
