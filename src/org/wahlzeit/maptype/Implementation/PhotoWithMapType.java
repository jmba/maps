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
    public static final String IDENTCODE = "identcode";
    public static final String AREA = "area";
    public static final String POPULATION = "population";


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
    public IMapType getMapType() {
        return mapType;
    }

    /**
     * @methodtype set
     * @param mapType
     */
    public void setMapType(IMapType mapType) {
        this.mapType = mapType;
    }


    @Override
	public void readFrom(ResultSet rset) throws SQLException {
		super.readFrom(rset);
		String identCodeString = rset.getString(IDENTCODE);
        int areaString = Integer.parseInt(rset.getString(AREA));
        int populationString = Integer.parseInt(rset.getString(POPULATION));

        try {
			this.mapType = MapTypeManager.createMapTypeObject(identCodeString);
            this.mapType.setArea(areaString);
            this.mapType.setPopulation(populationString);
		}
		catch (InvalidParameterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeOn(ResultSet rset) throws SQLException {
		super.writeOn(rset);
		if(mapType != null) {
			rset.updateString(IDENTCODE, this.mapType.getIdentCode());
            rset.updateString(AREA, Integer.toString(this.mapType.getArea()));
            rset.updateString(POPULATION,Integer.toString(this.mapType.getPopulation()));
		}
	}
}