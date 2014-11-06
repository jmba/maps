package org.wahlzeit.location.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {

	/**
	 * 
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(LocationTest.class);
		
		suite.addTest(org.wahlzeit.location.tests.AllTests.suite());	
		
		return suite;
	}
}
