package org.wahlzeit.maptype;

import org.wahlzeit.maptype.implementation.CityMap;
import org.wahlzeit.maptype.implementation.CountryMap;

/**
 * Created by Johannes Bayerl on 07.12.14.
 */
public class MapTypeManager {

    /**
     * @methodtype getter
     * @param identCode
     * @return
     */
    public static CityMap createCityMapObject(String identCode){
        CityMap cityMap = new CityMap();
        cityMap.setIdentCode(identCode);

        return cityMap;
    }

    /**
     * @methodtype getter
     * @param identCode
     * @return
     */
    public static CountryMap createCountryMapObject(String identCode){
        CountryMap countryMap = new CountryMap();
        countryMap.setIdentCode(identCode);

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
    public static IRealAreaMapType createMapTypeObject(String identCode){
        IRealAreaMapType mapType = null;

        String pattern = "[a-zA-Z]+";

        if(identCode.length()== 3 && identCode.matches(pattern)){
            mapType = createCityMapObject(identCode);
        } else if(identCode.length()== 2 && identCode.matches(pattern)){
            mapType = createCountryMapObject(identCode);
        } else {
            throw new IllegalArgumentException("Please enter the ident-code in valid format");
        }

        return mapType;
    }
}
