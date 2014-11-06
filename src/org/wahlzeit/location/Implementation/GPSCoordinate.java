package org.wahlzeit.location.Implementation;

public class GPSCoordinate {
	
	public enum CoordinateDirection {
		  NORTH, EAST, SOUTH, WEST
	}
	
	CoordinateDirection direction;
	double degree = 0.0;
	
	public CoordinateDirection getDirection() {
		return direction;
	}
	
	public void setDirection(CoordinateDirection direction) {
		this.direction = direction;
	}

	public double getDegree() {
		return degree;
	}

	public void setDegree(double degree) {
		this.degree = degree;
	}
}
