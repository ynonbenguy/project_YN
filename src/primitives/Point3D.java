package primitives;

public class Point3D extends Point2D{
	private Coordinate z;
	
	//*constructors*//
	public Point3D(Coordinate x,Coordinate y,Coordinate z)   //constructor
	{
		super(x,y);
		this.z=z;
		
	}
	public Point3D(double x,double y,double z) //constructor type double
	{
		super(x,y);
		this.z = new Coordinate(z);
	}
	public Point3D(Point3D p) //copy constructor
	{
		x=new Coordinate(p.getX());
		y=new Coordinate(p.getY());
		z=new Coordinate(p.getZ());
	}
	public Point3D()  //default constructor 
	{
		super();
		this.z=new Coordinate(0);
	}
	
	//getters and setters*//
	
	
	public Coordinate getZ() {
		return z;
	}
	public void setZ(Coordinate z) {
		this.z = z;
	}
	public void setZ(double z)
	{
		this.z.setCoordinate(z);
	}
	
	//*operations*//
	public Vector vec_act(Point3D point2)  //vector by two points
	{
		double Dx=(point2.getX()).getCoordinate()-this.x.getCoordinate();
		double Dy=(point2.getY()).getCoordinate()-this.y.getCoordinate();
		double Dz=(point2.getZ()).getCoordinate()-this.z.getCoordinate();
		return new Vector(Dx,Dy,Dz);
	}
	public Point3D add_vector(Vector vec) //add vector to point
	{
		return new Point3D((this.x).add(vec.getHead().getX().getCoordinate()),(this.y).add(vec.getHead().getY().getCoordinate()),(this.z).add(vec.getHead().getZ().getCoordinate()));
	}
	public double distance(Point3D point2) //distance between two points
	{
		return (Math.pow(point2.getX().getCoordinate()-(this.x).getCoordinate(),2)+Math.pow(point2.getY().getCoordinate()-(this.y).getCoordinate(),2)+Math.pow(point2.getZ().getCoordinate()-(this.z).getCoordinate(), 2));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Point3D : x=" + x + ", y=" + y +" ,z=" + z ;
	}
}
