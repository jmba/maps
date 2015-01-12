package org.wahlzeit.maptype;

import junit.framework.TestCase;
import org.wahlzeit.collaboration.implementation.ArtworkMapRole;
import org.wahlzeit.collaboration.implementation.MapCore;
import org.wahlzeit.collaboration.implementation.RealAreaMapRole;
import org.wahlzeit.maptype.implementation.CityMap;

/**
 * Created by jonet on 11.01.15.
 */
public class RoleObjectTest extends TestCase {
    public void testRoleObjectTest()  {
        //Create role
        CityMap map = new CityMap();
        map.setIdentCode("ERH");

        MapCore core = new MapCore();
        core.addRole("RealAreaMapRole",map);

        RealAreaMapRole realAreaMapRole = (RealAreaMapRole) core.getRole("RealAreaMapRole");
        assertTrue(realAreaMapRole.getIdentCode().equals("ERH"));
        assertTrue(realAreaMapRole instanceof CityMap);
    }

    public void testRoleObjectWithCreationTest()  {
        MapCore core = new MapCore();
        core.addRole("ArtworkMapRole");
        assertTrue(core.getRole("ArtworkMapRole") instanceof ArtworkMapRole);
    }
}
