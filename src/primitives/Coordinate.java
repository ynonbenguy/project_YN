package primitives;

public class Coordinate {
	private double coordinate;
	
	
	private static final int ACCURACY = -20;
	private int getExp(double num) {
		return (int)((Double.doubleToRawLongBits(num) >> 52) & 0x7FFL) - 1023;
	}
	
	//*constructors*//
	
	public Coordinate(double coord)      //constructor
	{
		this.coordinate=(getExp(coord) < ACCURACY) ? 0.0 : coord;
	}
	public Coordinate(Coordinate other) {            //copy constructor
		this.coordinate = other.getCoordinate();
	}
	public Coordinate() //default constructor
	{
		coordinate=0;
	}
	
	
	//*getters and setters*//
	
	public double getCoordinate() {//get
		return coordinate;
	}
	public void setCoordinate(double coordinate) { //set
		this.coordinate = coordinate;
	}
	
	//*operations*//
	
	
	
	public double add(double other) //add coordinate func
	{
		int otherExp = getExp(coordinate);
		int thisExp = getExp(coordinate);
		if (otherExp - thisExp < ACCURACY) return coordinate;
		if (thisExp - otherExp < ACCURACY) return other;
		double result = coordinate + other;
		int resultExp = getExp(result);
		return resultExp - thisExp < ACCURACY ? 0.0 : result;
	}
	public double substract(double other) //substract coordinate func
	{
		int otherExp = getExp(other);
		int thisExp = getExp(coordinate);
		if (otherExp - thisExp < ACCURACY) return coordinate;
		if (thisExp - otherExp < ACCURACY) return other;
		double result = coordinate - other;
		int resultExp = getExp(result);
		return resultExp - thisExp < ACCURACY ? 0.0 : result;
	}
	public Coordinate substract(Coordinate other)
	{
		return new Coordinate(substract(other.getCoordinate()));
	}
	public Coordinate add(Coordinate other)
	{
		return new Coordinate(add(other.getCoordinate()));
	}
	
	
	
	@Override
	public boolean equals(Object obj) {          //equals
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Coordinate)) return false;
		Coordinate other = (Coordinate)obj;
		return (substract(other.coordinate) == 0.0);
	}
	

@Override
public String toString() {
	return "Coordinate " + coordinate ;
}
}
