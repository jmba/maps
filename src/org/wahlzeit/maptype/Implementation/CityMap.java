package org.wahlzeit.maptype.Implementation;

/**
 * Represents the map of a city. The used ident-code format is
 * IATA 3-letter code which is used on airports.
 *
 * Examples: Milan:  BGY, Munic: MUC
 *
 * Created by Johannes Bayerl on 21.11.14.
 */
public class CityMap extends AbstractMapType {

    private String cityCode = "";

    /**
     * @param cityCode
     * @throws IllegalArgumentException
     * @methodtype setter
     */
    @Override
    protected void doSetIdentCode(String cityCode) throws IllegalArgumentException {
        assertCityCodeFormat(cityCode);
        this.cityCode = cityCode;
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
}
