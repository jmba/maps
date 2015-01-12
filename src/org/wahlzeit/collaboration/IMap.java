package org.wahlzeit.collaboration;

import org.wahlzeit.collaboration.implementation.MapRole;

/**
 * Created by Johannes Bayerl on 11.01.15.
 *
 * Provide interface like specified in role-object-pattern.
 *
 * MapCore and MapRole collaborate to create and handle objects.
 *
 * MapCore provides a HashMap including roles. If a new role should be added, the MapCore object
 * checks if the role is already in the map. If it is not in the map, the request gets forwarded to
 * the corresponding MapRole, where the object-creation take place.
 *
 * If a object which is derived from MapRole is asked to get a specified role it carries,
 * the request is forwarded to the MapCore object which provides the map with roles.
 */
public interface IMap {
    public MapRole getRole(String role);
    public void addRole(String role);
    public void addRole(String roleIdentifier, MapRole role);
}
