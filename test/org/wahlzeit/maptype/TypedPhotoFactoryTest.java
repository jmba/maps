package org.wahlzeit.maptype;

import junit.framework.TestCase;
import org.wahlzeit.maptype.implementation.CityMap;
import org.wahlzeit.maptype.implementation.CountryMap;
import org.wahlzeit.maptype.implementation.TypedPhoto;

/**
 * Created by jonet on 07.12.14.
 */
public class TypedPhotoFactoryTest extends TestCase {

    public void testCreatePhoto() {
        TypedPhoto photo = TypedPhotoFactory.getInstance().createPhoto();
        assertTrue((photo instanceof TypedPhoto));
    }

    public void testSetPhotoType(){
        TypedPhoto photo = TypedPhotoFactory.getInstance().createPhoto();
        CountryMap countryMap = (CountryMap) MapTypeManager.createMapTypeObject("DE");
        photo.setPhotoType(countryMap);
        assertTrue((photo.getPhotoType() instanceof CountryMap));
    }

    public void testGetMapTypeObject(){
        CountryMap countryMap = (CountryMap) MapTypeManager.createMapTypeObject("DE");
        CityMap cityMap = (CityMap) MapTypeManager.createMapTypeObject("NYC");

        assertTrue(countryMap.getIdentCode() == "DE");
        assertTrue(cityMap.getIdentCode() == "NYC");
        assertTrue((countryMap instanceof CountryMap));
        assertTrue((cityMap instanceof CityMap));
    }

    public void testGetCityMapObject(){
        CityMap cityMap = (CityMap) MapTypeManager.createCityMapObject("NYC");
        assertTrue(cityMap.getIdentCode() == "NYC");
    }

    public void testGetCountryMapObject(){
        CountryMap countryMap = (CountryMap) MapTypeManager.createCountryMapObject("DE");
        assertTrue((countryMap instanceof CountryMap));
    }
}