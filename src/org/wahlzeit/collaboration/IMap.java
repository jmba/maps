package org.wahlzeit.collaboration;

import org.wahlzeit.collaboration.implementation.MapRole;

/**
 * Created by jonet on 11.01.15.
 */
public interface IMap {
    public MapRole getRole(String role);
    public void addRole(String role);
}
