package org.wahlzeit.maptype;

import org.wahlzeit.maptype.implementation.CityMap;
import org.wahlzeit.maptype.implementation.CountryMap;
import org.wahlzeit.maptype.implementation.MapTypeIdentCodeException;

import java.sql.SQLException;

/**
 * Created by Johannes Bayerl on 07.12.14.
 */
public class MapTypeManager {

    /**
     * @methodtype getter
     * @param identCode
     * @return
     */
    public static CityMap createCityMapObject(String identCode) throws MapTypeIdentCodeException {
        CityMap cityMap = new CityMap();

        try{
            cityMap.setIdentCode(identCode);
        }catch(IllegalArgumentException iAex){
            throw new MapTypeIdentCodeException();
        }
        return cityMap;
    }

    /**
     * @methodtype getter
     * @param identCode
     * @return
     */
    public static CountryMap createCountryMapObject(String identCode) throws MapTypeIdentCodeException{
        CountryMap countryMap = new CountryMap();
        try{
            countryMap.setIdentCode(identCode);
        }catch(IllegalArgumentException iAex){
            throw new MapTypeIdentCodeException();
        }

        return countryMap;
    }

    /**
     * Decides if the given ident-code fits to CountryMap-type
     * or CityMap-type
     *
     * @methodtype getter
     * @param identCode
     * @return
     */
    public static IRealAreaMapType createMapTypeObject(String identCode)  throws MapTypeIdentCodeException{
        IRealAreaMapType mapType = null;

        String pattern = "[a-zA-Z]+";

        try {
            if (identCode.length() == 3 && identCode.matches(pattern)) {
                mapType = createCityMapObject(identCode);

            } else if (identCode.length() == 2 && identCode.matches(pattern)) {
                mapType = createCountryMapObject(identCode);
            } else {
                throw new IllegalArgumentException("Please enter the ident-code in valid format");
            }
        }
        catch(IllegalArgumentException iAex){
              throw new MapTypeIdentCodeException();
        }

        return mapType;
    }
}
