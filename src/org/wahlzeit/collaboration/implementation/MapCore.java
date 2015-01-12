package org.wahlzeit.collaboration.implementation;

import org.wahlzeit.collaboration.IMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Johannes Bayerl on 11.01.15.
 */
public class MapCore implements IMap {

    Map<String, MapRole> roles = new HashMap();

    @Override
    public MapRole getRole(String role) {
        return roles.get(role);
    }

    @Override
    public void addRole(String roleIdentifier) {
        MapRole mRole = getRole(roleIdentifier);
        if(mRole == null){
            mRole = MapRole.createFor(roleIdentifier,this);
            if(mRole != null){
                roles.put(roleIdentifier, mRole);
            }
        }
    }

    @Override
    public void addRole(String roleIdentifier, MapRole role) {
        MapRole mRole = getRole(roleIdentifier);
        if(mRole == null){
            roles.put(roleIdentifier,role);
        }
    }
}