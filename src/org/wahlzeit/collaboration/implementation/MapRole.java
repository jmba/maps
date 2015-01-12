package org.wahlzeit.collaboration.implementation;

import org.wahlzeit.collaboration.IMap;
import org.wahlzeit.maptype.MapTypeManager;

/**
 * Created by Johannes Bayerl on 11.01.15.
 */
public abstract class MapRole implements IMap {

    private MapCore core;

    static MapRole createFor(String role, MapCore core){
        MapRole returnRole = null;
        if(role.equals(ArtworkMapRole.ROLE_IDENTIFIER)){
            returnRole = new ArtworkMapRole();
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
        MapRole mRole = null;
        if(core != null){
            mRole = core.getRole(role);
        }
        return mRole;
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
    public void addRole(String roleIdentifier, MapRole role) {
        core.addRole(roleIdentifier,role);
    }

    public abstract String asString();
}