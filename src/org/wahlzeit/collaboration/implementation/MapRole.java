package org.wahlzeit.collaboration.implementation;

import org.wahlzeit.collaboration.IMap;

/**
 * Created by jonet on 11.01.15.
 */
public class MapRole implements IMap {

    private MapCore core;

    static MapRole createFor(String role, MapCore core){
        MapRole returnRole = null;
        if(role.equals("ArtworkMapRole")){
            returnRole = new ArtworkMapRole();
        } else if (role.equals("RealAreaMapRole")){
            returnRole = new RealAreaMapRole();
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


    @Override
    public String asString() {
        return null;
    }
}