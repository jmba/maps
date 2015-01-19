package org.wahlzeit.maptype.implementation;

import junit.framework.Assert;
import org.wahlzeit.collaboration.implementation.RealAreaMapRole;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Represents the map of a city. The used ident-code format is
 * IATA 3-letter code which is used on airports.
 *
 * Examples: Milan:  BGY, Munic: MUC
 *
 * Created by Johannes Bayerl on 21.11.14.
 */
public class CityMap extends RealAreaMapRole {
    public static final String CITYCODE = "citycode";
    private String cityCode = "";

    /**
     * @param cityCode
     * @throws IllegalArgumentException
     * @methodtype setter
     */
    @Override
    protected void doSetIdentCode(String cityCode) {
        assertCityCodeFormat(cityCode);
        this.cityCode = cityCode;

        // Postcondition
        Assert.assertSame(this.cityCode,cityCode);
    }

    /**
     * @return
     * @methodtype getter
     */
    @Override
    protected String doGetIdentCode() {
        return cityCode;
    }

    private void assertCityCodeFormat(String cityCode){

        String pattern = "[a-zA-Z]+";

        if(!(cityCode.length()==3 && cityCode.matches(pattern))){
            throw new IllegalArgumentException("Please enter the city-code in valid format");
        }
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        rset.updateString(CITYCODE, cityCode);
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException{
        super.readFrom(rset);
        cityCode = rset.getString(CITYCODE);
    }
}