package org.wahlzeit.maptype;

import org.wahlzeit.location.Implementation.GPSLocation;
import org.wahlzeit.maptype.Implementation.CityMap;
import org.wahlzeit.maptype.Implementation.CountryMap;

import java.util.HashMap;

/**
 * Created by jonet on 07.12.14.
 */
public class MapTypeManager {

    public static CityMap getCityMapObject(String identCode){
        CityMap cityMap = new CityMap();
        cityMap.setIdentCode(identCode);

        return cityMap;
    }

    public static CountryMap getCountryMapObject(String identCode){
        CountryMap countryMap = new CountryMap();
        countryMap.setIdentCode(identCode);

        return countryMap;
    }

    public static IMapType getMapTypeObject(String identCode){
        IMapType mapType = null;

        String pattern = "[a-zA-Z]+";

        if(identCode.length()== 3 && identCode.matches(pattern)){
            mapType = new CityMap();
            mapType.setIdentCode(identCode);
        } else if(identCode.length()== 2 && identCode.matches(pattern)){
            mapType = new CountryMap();
            mapType.setIdentCode(identCode);
        } else {
            throw new IllegalArgumentException("Please enter the ident-code in valid format");
        }

        return mapType;
    }
}
