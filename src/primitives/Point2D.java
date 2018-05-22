package primitives;

public class Point2D {
	protected Coordinate x;
	protected Coordinate y;
	
	
	//*constructors*//
	public Point2D(Coordinate x2,Coordinate y2)//constructor
	{
		this.x=x2;
		this.y=y2;
	}
	public Point2D(double x2,double y2)//constructor type double
	{
		this.x= new Coordinate(x2);
		this.y = new Coordinate(y2);
	}
	public Point2D()   //default constructor
	{
		this.x=new Coordinate(0);
		this.y=new Coordinate(0);
	}
	
	//*getters and setters*//
	
	
	public Coordinate getX() {
		return x;
	}
	public void setX(Coordinate x) {
		this.x = x;
	}
	public void setX(double x)
	{
		this.x.setCoordinate(x);
	}
	public Coordinate getY() {
		return y;
	}
	public void setY(Coordinate y) {
		this.y = y;
	}
	public void setY(double y)
	{
		this.y.setCoordinate(y);
	}
	
	//operations
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Point2D : x=" + x + ", y=" + y ;
	}
}
