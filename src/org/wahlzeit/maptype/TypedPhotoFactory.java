package org.wahlzeit.maptype;

import org.wahlzeit.maptype.implementation.TypedPhoto;
import org.wahlzeit.model.*;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Johannes Bayerl on 07.12.14.
 *
 * Factorymethod for PhotoWithMapType-objects.
 *
 */
public class TypedPhotoFactory extends PhotoFactory {
    private static TypedPhotoFactory instance = null;

    public TypedPhotoFactory() {}

    /**
     * @return Singleton-instance
     */
    public static TypedPhotoFactory getInstance() {
        if (instance == null) {
            instance = new TypedPhotoFactory();
        }
        return instance;
    }

    /**
     * @methodtype factory
     */
    public TypedPhoto createPhotoWithSpecifiedType(IPhotoType type) {
        TypedPhoto photo = new TypedPhoto();
        photo.setPhotoType(type);
        return photo;
    }

    /**
     * @methodtype factory
     */
    public TypedPhoto createPhoto() {
        return new TypedPhoto();
    }



    /**
     * @methodtype factory
     */
    public TypedPhoto createPhoto(PhotoId id) {
        return new TypedPhoto(id);
    }

    /**
     * @methodtype factory
     */
    public TypedPhoto createPhoto(ResultSet rs) throws SQLException {
        return new TypedPhoto(rs);
    }
}