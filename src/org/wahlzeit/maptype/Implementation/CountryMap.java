package org.wahlzeit.maptype.implementation;

import junit.framework.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents the map of a country. The used ident-code format is
 * ISO 3166 2-letter code.
 *
 * Examples: Afghanistan:  AF, Germany: DE
 *
 * Created by Johannes Bayerl on 21.11.14.
 */
public class CountryMap extends AbstractMapType {

    public static final String COUNTRYCODE = "countrycode";
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

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        rset.updateString(COUNTRYCODE,countryCode);
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException{
        super.readFrom(rset);
        countryCode = rset.getString(COUNTRYCODE);
    }
}