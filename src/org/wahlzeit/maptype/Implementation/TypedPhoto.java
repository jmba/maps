package org.wahlzeit.maptype.implementation;

import org.wahlzeit.maptype.IPhotoType;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jonet on 07.12.14.
 * Typed Photo is a photo with an specified type
 */
public class TypedPhoto extends Photo {

    private IPhotoType photoType;

    public TypedPhoto(){ }

    public TypedPhoto(PhotoId id){
        super(id);
    }

    public TypedPhoto(ResultSet rs) throws SQLException {
        super(rs);
    }

    /**
     * @methodtype getter
     */
    public IPhotoType getPhotoType() {
        return photoType;
    }

    /**
     * @methodtype setter
     */
    public void setPhotoType(IPhotoType photoType) {
        this.photoType = photoType;
    }


    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        if(photoType != null) {
            photoType.readFrom(rset);
        }
    }

    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        if(photoType != null) {
            photoType.writeOn(rset);
        }
    }
}