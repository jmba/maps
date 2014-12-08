package org.wahlzeit.maptype;

import junit.framework.TestCase;
import org.wahlzeit.maptype.Implementation.CityMap;
import org.wahlzeit.maptype.Implementation.CountryMap;
import org.wahlzeit.maptype.Implementation.PhotoWithMapType;

/**
 * Created by jonet on 07.12.14.
 */
public class PhotoWithMapTypeFactoryTest extends TestCase {

    public void testCreatePhoto() {
        PhotoWithMapType photo = PhotoWithMapTypeFactory.getInstance().createPhoto();
        assertTrue((photo instanceof PhotoWithMapType));
    }

    public void testGetMapTypeObject(){
        CountryMap countryMap = (CountryMap) MapTypeManager.createMapTypeObject("DE");
        CityMap cityMap = (CityMap) MapTypeManager.createMapTypeObject("NYC");

        assertTrue(countryMap.getIdentCode().equals("DE"));
        assertTrue(cityMap.getIdentCode().equals("NYC"));
        assertTrue((countryMap instanceof CountryMap));
        assertTrue((cityMap instanceof CityMap));
    }

    public void testGetCityMapObject(){
        CityMap cityMap = (CityMap) MapTypeManager.createCityMapObject("NYC");
        assertTrue(cityMap.getIdentCode().equals("NYC"));
    }

    public void testGetCountryMapObject(){
        CountryMap countryMap = (CountryMap) MapTypeManager.createCountryMapObject("DE");
        assertTrue((countryMap instanceof CountryMap));
    }
}