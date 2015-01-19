package org.wahlzeit.maptype;

import junit.framework.TestCase;
import org.wahlzeit.maptype.implementation.CityMap;
import org.wahlzeit.maptype.implementation.CountryMap;
import org.wahlzeit.maptype.implementation.MapTypeIdentCodeException;
import org.wahlzeit.maptype.implementation.TypedPhoto;

/**
 * Created by jonet on 07.12.14.
 */
public class TypedPhotoFactoryTest extends TestCase {

    public void testCreatePhoto() {
        TypedPhoto photo = TypedPhotoFactory.getInstance().createPhoto();
        assertTrue((photo instanceof TypedPhoto));
    }

    public void testSetPhotoType() throws MapTypeIdentCodeException{
        TypedPhoto photo = TypedPhotoFactory.getInstance().createPhoto();
        CountryMap countryMap = (CountryMap) MapTypeManager.createMapTypeObject("DE");
        photo.setPhotoType(countryMap);
        assertTrue((photo.getPhotoType() instanceof CountryMap));
    }

    public void testGetMapTypeObject() throws MapTypeIdentCodeException{
        CountryMap countryMap = (CountryMap) MapTypeManager.createMapTypeObject("DE");
        CityMap cityMap = (CityMap) MapTypeManager.createMapTypeObject("NYC");

        assertTrue(countryMap.getIdentCode() == "DE");
        assertTrue(cityMap.getIdentCode() == "NYC");
        assertTrue((countryMap instanceof CountryMap));
        assertTrue((cityMap instanceof CityMap));
    }

    public void testGetCityMapObject() throws MapTypeIdentCodeException{
        CityMap cityMap = (CityMap) MapTypeManager.createCityMapObject("NYC");
        assertTrue(cityMap.getIdentCode() == "NYC");
    }

    public void testCreateWrongFormatCityMapObject(){
        Boolean exceptionTrown = false;

        try{
            CityMap cityMap = (CityMap) MapTypeManager.createCityMapObject("foooo");
        }catch(MapTypeIdentCodeException mtice) {
            exceptionTrown =true;
        }

        assertTrue(exceptionTrown);
    }

    public void testCreateWrongFormatCountryMapObject() {
        Boolean exceptionTrown = false;

        try{
            CountryMap cityMap = (CountryMap) MapTypeManager.createCountryMapObject("foooo");
        }catch(MapTypeIdentCodeException mtice) {
            exceptionTrown =true;
        }

        assertTrue(exceptionTrown);
    }


    public void testGetCountryMapObject() throws  MapTypeIdentCodeException{
        CountryMap countryMap = (CountryMap) MapTypeManager.createCountryMapObject("DE");
        assertTrue((countryMap instanceof CountryMap));
    }
}