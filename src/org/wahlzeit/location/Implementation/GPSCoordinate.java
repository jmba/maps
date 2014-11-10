package org.wahlzeit.location.Implementation;

/**
 * Concrete representation of a gps coordinate. It
 * consists of an direction and an degree-value.
 * @author jonet
 *
 */
public class GPSCoordinate {

	String coordinateDirection = "";
	double degree = 0.0;
	
	public String getDirection() {
		return coordinateDirection;
	}
	
	public void setDirection(String direction) {
		this.coordinateDirection = direction;
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}
}
