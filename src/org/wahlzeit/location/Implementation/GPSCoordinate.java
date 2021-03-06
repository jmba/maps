package org.wahlzeit.location.implementation;

/**
 * Concrete representation of a gps coordinate. It
 * consists of an direction and an degree-value.
 * @author jonet
 *
 */
public final class GPSCoordinate {

	private final String coordinateDirection;
	private final double degree;

	GPSCoordinate(String coordinateDirection,double degree){
		this.degree = degree;
		this.coordinateDirection = coordinateDirection;
	}

	public final  String getDirection() {
		return coordinateDirection;
	}
	public final double getDegree() {
		return degree;
	}
}
