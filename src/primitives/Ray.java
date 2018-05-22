package primitives;

public class Ray {
	private Point3D p00;
	private Vector direction;
	
	//*constructors*//
	
	public Ray(Point3D p00, Vector direction) { //constructor
		this.p00 = p00;
		this.direction = direction;
	}
	public Ray()  //default constructor
	{
		p00=new Point3D(0,0,0);
		direction=new Vector(0,0,0);
	}
	public Ray(Ray r)  //copy constructor
	{
		this.p00=r.getP00();
		this.direction=r.getDirection();
	}
	
	//* getters and setters*//
	public Point3D getP00() {
		return p00;
	}
	public void setP00(Point3D p00) {
		this.p00 = p00;
	}
	public void setP00(double x,double y,double z)
	{
		p00.setX(x);
		p00.setY(y);
		p00.setZ(z);
	}
	public Vector getDirection() {
		return direction;
	}
	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	public void setDirection(double x,double y,double z)
	{
		this.direction.setHead(x, y, z);
	}

	
	
	
	@Override
	public boolean equals(Object obj) { //equals function
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (p00 == null) {
			if (other.p00 != null)
				return false;
		} else if (!p00.equals(other.p00))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Ray: " + "p00: (" +p00.getX().getCoordinate()+","+p00.getY().getCoordinate()+","+p00.getZ().getCoordinate()+")"+"direction: ("+direction.getHead().getX().getCoordinate()+","+direction.getHead().getY().getCoordinate()+","+direction.getHead().getZ().getCoordinate()+")";
	}

}
