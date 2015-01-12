package org.wahlzeit.maptype;

import org.wahlzeit.location.ILocation;

import java.io.Serializable;

/**
 * Interface to implement in different concrete maptypes.
 *
 * Created by Johannes Bayerl on 12.11.2014
 */
public interface IRealAreaMapType extends IPhotoType {

    /**
     * @return
     * @methodtype getter
     */
    public int getPopulation();

    /**
     * @param population
     */
    public void setPopulation(int population);

    /**
     * @return
     * @methodtype getter
     */
    public int getArea();

    /**
     * @param area
     */
    public void setArea(int area);

    /**
     * @return
     * @methodtype getter
     */
    public String getIdentCode();

    /**
     * @param identCode (unique identifier for what's shown on the map)
     * @methodtype setter
     * @throws IllegalArgumentException if ident-code is syntactically wrong
     * Precondition: semantic check (given ident-code must match to what's shown on the map)
     * Precondition: Argument must not be null
     * Postcondition: ident-code gets syntax-checked in concrete implementations and set correctly
     */
    public void setIdentCode(String identCode);

    /**
     * @methodtype setter
     * @param location (value object)
     * @Precondition: Argument must not be null
     * @Postcondition: Location set correctly
     */
    public void setLocation(ILocation location);

    /**
     * @methodtype getter
     * @return the value-object location
     */
    public ILocation getLocation();

}
