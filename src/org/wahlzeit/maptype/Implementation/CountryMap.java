package org.wahlzeit.maptype.Implementation;

import junit.framework.Assert;

/**
 * Represents the map of a country. The used ident-code format is
 * ISO 3166 2-letter code.
 *
 * Examples: Afghanistan:  AF, Germany: DE
 *
 * Created by Johannes Bayerl on 21.11.14.
 */
public class CountryMap extends AbstractMapType {

    private String countryCode = "";

    /**
     * @methodtype setter
     * @param countryCode
     * @throws IllegalArgumentException
     */
    @Override
    protected void doSetIdentCode(String countryCode) throws IllegalArgumentException {
        assertCountryCodeFormat(countryCode);
        this.countryCode = countryCode;

        // Postcondition
        Assert.assertSame(this.countryCode, countryCode);
    }

    /**
     * @methodtype getter
     * @return
     */
    @Override
    protected String doGetIdentCode() {
        return countryCode;
    }

    private void assertCountryCodeFormat(String countryCode){

        String pattern = "[a-zA-Z]+";

        if(!(countryCode.length()== 2 && countryCode.matches(pattern))){
            throw new IllegalArgumentException("Please enter the country-code in valid format");
        }
    }
}