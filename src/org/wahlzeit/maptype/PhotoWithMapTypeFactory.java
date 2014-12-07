package org.wahlzeit.maptype;

import org.wahlzeit.maptype.Implementation.PhotoWithMapType;
import org.wahlzeit.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Johannes Bayerl on 07.12.14.
 *
 * Factorymethod for PhotoWithMapType-objects.
 *
 */
public class PhotoWithMapTypeFactory extends PhotoFactory {
    private static PhotoWithMapTypeFactory instance = null;

    private PhotoWithMapTypeFactory() {}

    /**
     * @return Singleton-instance
     */
    public static PhotoWithMapTypeFactory getInstance() {
        if (instance == null) {
            instance = new PhotoWithMapTypeFactory();
        }
        return instance;
    }

    /**
     * @methodtype factory
     */
    public PhotoWithMapType createPhoto() {
        return new PhotoWithMapType();
    }

    /**
     * @methodtype factory
     */
    public PhotoWithMapType createPhoto(PhotoId id) {
        return new PhotoWithMapType(id);
    }

    /**
     * @methodtype factory
     */
    public PhotoWithMapType createPhoto(ResultSet rs) throws SQLException {
        return new PhotoWithMapType(rs);
    }
}