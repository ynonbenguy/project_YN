
package geometries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import primitives.*;
public class Plane extends Geometry {
protected Point3D p1;
protected Vector V;


//*constructors*//

public Plane(Point3D p, Vector v,Color emision,Material material) {
	super(emision,material);
	this.p1 = p;
	this.V = v;
}
public Plane(Point3D p1,Point3D p2,Point3D p3,Color emision,Material material)
{
	super(emision, material);
	this.p1=p1;
	Vector V_A=new Vector(p2.vec_act(p1));
	Vector V_B=new Vector(p2.vec_act(p3));
	this.V=new Vector(V_A.cross_product(V_B));
}
public Plane()
{
	super();
	p1=new Point3D(0,0,0);
	V=new Vector(0,0,0);
}

//getters and setters*//
public Point3D getP1() {
	return p1;
}
public void setP1(Point3D p) {
	this.p1 = p;
}
public void setP1(double x,double y,double z)
{
	this.p1.setX(x);
	this.p1.setY(y);
	this.p1.setZ(z);
}
public Vector getV() {
	return V;
}
public void setV(Vector v) {
	V = v;
}
public void setV(double x,double y,double z)
{
	this.V.setHead(x,y,z);
}

public Map<Geometry,ArrayList<Point3D>> findIntersections(Ray R)
{
	Vector vec1=new Vector(R.getP00().vec_act((this.p1)));
	double num1=this.V.dot_product(vec1);
	double num2=(this.V).dot_product(R.getDirection());
	double t=num1/num2;
	Vector k=new Vector(R.getDirection().scalar(t));
	Point3D poit=new Point3D(R.getP00().add_vector(k)) ;  
	ArrayList<Point3D> list_intersection=new ArrayList<Point3D>();
	list_intersection.add(poit);
	Map<Geometry,ArrayList<Point3D>> intersections =
			new HashMap<Geometry,ArrayList<Point3D>> ();
	//Put list_intersection into intersections with geometry (this) as key
	intersections.put(this, list_intersection);
	return intersections;
}

public Vector get_normal(Point3D p)
{
	return V;
}
}