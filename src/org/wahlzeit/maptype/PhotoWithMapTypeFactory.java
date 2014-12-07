package org.wahlzeit.maptype;

import org.wahlzeit.maptype.Implementation.PhotoWithMapType;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFilter;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoTagCollector;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jonet on 07.12.14.
 */
public class PhotoWithMapTypeFactory {
    private static PhotoWithMapTypeFactory instance = null;

    private PhotoWithMapTypeFactory() {}

    /**
     * @type
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
    public Photo createPhoto() {
        return new PhotoWithMapType();
    }

    /**
     *
     */
    public Photo createPhoto(PhotoId id) {
        return new PhotoWithMapType(id);
    }

    /**
     *
     */
    public Photo createPhoto(ResultSet rs) throws SQLException {
        return new PhotoWithMapType(rs);
    }

    /**
     *
     */
    public PhotoFilter createPhotoFilter() {
        return new PhotoFilter();
    }

    /**
     *
     */
    public PhotoTagCollector createPhotoTagCollector() {

        return new PhotoTagCollector();
    }
}
