package org.wahlzeit.maptype;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jonet on 12.12.14.
 * Type-interface for photos
 */
public interface IPhotoType {

    /**
     * @param rset
     */
    void writeOn(ResultSet rset) throws SQLException;

    /**
     * @param rset
     */
    public void readFrom(ResultSet rset) throws SQLException;
}
