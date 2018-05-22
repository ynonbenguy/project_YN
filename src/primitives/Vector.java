
package primitives;

public class Vector {
	private Point3D head;

	
	//*constructors*//
	public Vector(Point3D head) {
	this.head = head;
}
	public Vector(double x,double y,double z){
	head=new Point3D(x,y,z);
}
	public Vector(Vector v)
{
	head=new Point3D(v.getHead().getX(),v.getHead().getY(),v.getHead().getZ());
}
	public Vector()
{
	head=new Point3D(0,0,0);
}
	
	//getters and setters*//
public Point3D getHead() {
	return head;
}
public void setHead(Point3D head) {
	this.head = head;
}
public void setHead(double x,double y,double z)
{
	head.setX(x);
	head.setY(y);
	head.setZ(z);
}

//*operations*//

public Vector add_vector(Vector vec) //add vector
{
	return new Vector((this.head).getX().add(vec.getHead().getX().getCoordinate()),(this.head).getY().add(vec.getHead().getY().getCoordinate()),(this.head).getZ().add(vec.getHead().getZ().getCoordinate()));
}
public Vector sub_vector(Vector vec) //substract vector
{
	return new Vector((this.head).getX().substract(vec.getHead().getX().getCoordinate()),(this.head).getY().substract(vec.getHead().getY().getCoordinate()),(this.head).getZ().substract(vec.getHead().getZ().getCoordinate()));
}
public double dot_product(Vector vec)  //dot product
{
	return((this.head.getX().getCoordinate())*(vec.getHead().getX().getCoordinate())+(this.head.getY().getCoordinate())*(vec.getHead().getY().getCoordinate())+(this.head.getZ().getCoordinate())*(vec.getHead().getZ().getCoordinate()));
}
public Vector cross_product(Vector vec)  //cross product
{
	return new Vector((this.head.getY().getCoordinate())*(vec.getHead().getZ().getCoordinate())-(this.head.getZ().getCoordinate())*(vec.getHead().getY().getCoordinate()),((this.head.getZ().getCoordinate())*(vec.getHead().getX().getCoordinate())-(this.head.getX().getCoordinate())*(vec.getHead().getZ().getCoordinate())),((this.head.getX().getCoordinate())*(vec.getHead().getY().getCoordinate())-(this.head.getY().getCoordinate())*(vec.getHead().getX().getCoordinate())));
}
public void normalization()   //normalize
{
	/*double num1=this.length_vec();
	double X=((this.head.getX().getCoordinate())/num1);
	double Y=(this.head.getY().getCoordinate()/num1);
	double Z=this.head.getZ().getCoordinate()/num1;
	return new Vector(X,Y,Z);*/
	double num1=Math.pow((this.head.getX().getCoordinate()),2)+Math.pow((this.head.getY().getCoordinate()),2)+Math.pow((this.head.getZ().getCoordinate()),2);
	double num=Math.sqrt(num1);
	(this).setHead((this.head.getX().getCoordinate())/num,(this.head.getY().getCoordinate())/num,(this.head.getZ().getCoordinate())/num);
}
public Vector scalar(double num)  //mult vector in scalar
{
	Vector v=new Vector((this.head.getX().getCoordinate())*num,(this.head.getY().getCoordinate())*num,(this.head.getZ().getCoordinate())*num);
	return v;
}
public double length_vec()  //length of vector
{
	double num=Math.sqrt(Math.pow((head.getX().getCoordinate()),2)+Math.pow((head.getY().getCoordinate()),2)+Math.pow((head.getZ().getCoordinate()),2));
	return num;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Vector other = (Vector) obj;
	if (head == null) {
		if (other.head != null)
			return false;
	} else if (!head.equals(other.head))
		return false;
	return true;
}
@Override
public String toString() {
	return "Vector :("+this.head.getX().getCoordinate()+","+this.head.getY().getCoordinate()+","+this.head.getZ().getCoordinate()+")";
}

}