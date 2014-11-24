package org.wahlzeit.maptype.Implementation;

import org.wahlzeit.location.ILocation;
import  org.wahlzeit.maptype.IMapType;

/**
 * Abstract class which implements default implementation for all maptypes.
 *
 * Created by Johannes Bayerl on 21.11.14.
 */
public abstract class AbstractMapType implements IMapType {

    private int population;
    private int area;
    ILocation location;

    /**
     * @methodtype getter
     * @return
     */
    @Override
    public int getPopulation() {
        return population;
    }

    /**
     * @methodtype setter
     * @param population
     * @throws java.lang.IllegalArgumentException
     */
    @Override
    public void setPopulation(int population) {
        if(population>=0) {
            this.population = population;
        } else{
            throw new IllegalArgumentException("Population must not be negative");
        }
    }

    /**
     * @methodtype getter
     * @return
     */
    @Override
    public int getArea() {
        return area;
    }

    /**
     * @methodtype setter
     * @param area
     * @throws java.lang.IllegalArgumentException
     */
    @Override
    public void setArea(int area) {
        if(population>=0) {
            this.area = area;
        } else{
            throw new IllegalArgumentException("Area must not be negative");
        }
    }

    /**
     * @methodtype getter
     * @return
     */
    @Override
    public String getIdentCode() {
        return doGetIdentCode();
    }

    /**
     * @methodtype setter
     * @param code
     * @throws java.lang.IllegalArgumentException
     */
    @Override
    public void setIdentCode(String code) {
        if(code != null) {
            doSetIdentCode(code);
        } else {
            throw new IllegalArgumentException("ident-code must not be null");
        }
    }

    /**
     * @methodtype setter
     * @param location (value object)
     */
    @Override
    public void setLocation(ILocation location){
        if(location != null) {
            this.location = location;
        } else {
            throw new IllegalArgumentException("location must not be null");
        }
    }

    /**
     * @methodtype getter
     * @return the value-object location
     */
    @Override
    public ILocation getLocation(){
        return location;
    }

    /**
     * Implemented in derived classes. The used standard depends
     * on the concrete implementation.
     *
     * @param identCode
     * @methodtype setter
     */
    protected abstract void doSetIdentCode(String identCode);

    /**
     * Implemented in derived classes. The used standard depends
     * on the concrete implementation.
     *
     * @return
     * @methodtype getter
     */
    protected abstract String doGetIdentCode();
}