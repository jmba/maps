package org.wahlzeit.maptype.Implementation;

import org.wahlzeit.maptype.IMapType;
import org.wahlzeit.maptype.MapTypeManager;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

import java.security.InvalidParameterException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jonet on 07.12.14.
 */
public class PhotoWithMapType extends Photo {
    private IMapType mapType;
    public static final String MAPTYPE = "maptype";

    public PhotoWithMapType(){ }

    public PhotoWithMapType(PhotoId id){
        super(id);
    }

    public PhotoWithMapType(ResultSet rs) throws SQLException {
        super(rs);
    }

    /**
     * @methodtype get
     * @return
     */
    public IMapType getMapTape() {
        return mapType;
    }

    /**
     * @methodtype set
     * @param mapTape
     */
    public void setMapTape(IMapType mapTape) {
        this.mapType = mapTape;
    }


    @Override
	public void readFrom(ResultSet rset) throws SQLException {
		super.readFrom(rset);
		String mapTypeString = rset.getString(MAPTYPE);
		try {
			this.mapType = MapTypeManager.getMapTypeObject(mapTypeString);
		}
		catch (InvalidParameterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeOn(ResultSet rset) throws SQLException {
		super.writeOn(rset);
		if(mapType != null) {
			rset.updateString(MAPTYPE, this.mapType.getIdentCode());
		}
	}
}
