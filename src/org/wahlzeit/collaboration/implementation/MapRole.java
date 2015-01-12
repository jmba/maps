package org.wahlzeit.collaboration.implementation;

import org.wahlzeit.collaboration.IMap;
import org.wahlzeit.maptype.MapTypeManager;

/**
 * Created by jonet on 11.01.15.
 */
public abstract class MapRole implements IMap {

    private MapCore core;

    static MapRole createFor(String role, MapCore core){
        MapRole returnRole = null;
        if(role.equals(ArtworkMapRole.ROLE_IDENTIFIER)){
            returnRole = new ArtworkMapRole();
        } else if (role.equals(RealAreaMapRole.ROLE_IDENTIFIER)){
            //returnRole = new RealAreaMapRole();
        }

        returnRole.core = core;

        return returnRole;
    }

    /**
     * @methodtype: getter
     * @param role
     * @return
     */
    @Override
    public MapRole getRole(String role) {
        return null;
    }

    /**
     * @methodtype: setter
     * @param role
     */
    @Override
    public void addRole(String role) {
        core.addRole(role);
    }

    /**
     * @methodtype: setter
     * @param core
     */
    public void setCore(MapCore core){
        this.core = core;
    }

    /**
     * @methodtype: getter
     * @return
     */
    public MapCore getCore(){
        return this.core;
    }


    /**
     * Decides if the given ident-code fits to CountryMap-type
     * or CityMap-type
     *
     * @methodtype getter
     * @param identCode
     * @return
     */
    public static RealAreaMapRole createMapTypeObject(String identCode){
        RealAreaMapRole mapType = null;

        String pattern = "[a-zA-Z]+";

        if(identCode.length()== 3 && identCode.matches(pattern)){
            mapType = MapTypeManager.createCityMapObject(identCode);
        } else if(identCode.length()== 2 && identCode.matches(pattern)){
            mapType = MapTypeManager.createCountryMapObject(identCode);
        } else {
            throw new IllegalArgumentException("Please enter the ident-code in valid format");
        }

        return mapType;
    }

    public abstract String asString();
}