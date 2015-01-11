package org.wahlzeit.collaboration.implementation;

import org.wahlzeit.collaboration.IMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonet on 11.01.15.
 */
public class MapCore implements IMap {

    Map<String, MapRole> roles = new HashMap();

    @Override
    public MapRole getRole(String role) {
        return roles.get(role);
    }

    @Override
    public void addRole(String role) {
        MapRole mRole = getRole(role);
        if(mRole != null){
            mRole = MapRole.createFor(role,this);
            if(mRole != null){
                roles.put(role, mRole);
            }
        }
    }

    @Override
    public String asString() {
        return null;
    }
}