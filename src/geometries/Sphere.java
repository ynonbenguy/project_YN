package geometries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import primitives.*;
public class Sphere extends RadialGeometry {
	private  Point3D p;
	
	
	
	//constructors*//
	
	public Sphere(double radious, Point3D p,Color emission,Material material) {
		super(radious,emission,material);
		this.p = p;
	}
	public Sphere()
	{
		super();
		p=new Point3D(0,0,0);
	}
	
	
	//getters and setters*//
	
	public Point3D getP() {
		return p;
	}
	public void setP(Point3D p) {
		this.p = p;
	}
	public void setP(double x,double y,double z)
	{
		this.p.setX(x);
		this.p.setY(y);
		this.p.setZ(z);
	}
	
	//*operations*//
	
	public Map<Geometry,ArrayList<Point3D>> findIntersections(Ray R){
		ArrayList<Point3D> list_intersection=new ArrayList<Point3D>();
		Vector v=new Vector(R.getDirection());
		v.normalization();
		Vector u=new Vector(R.getP00().vec_act(this.p));
		double Tm=v.dot_product(u);
		double ul=u.length_vec();
		double d=Math.sqrt(ul*ul-Tm*Tm);
		if(d>getRadious()){
			return null;
		}
		double Th=Math.sqrt(Math.pow(getRadious(), 2)-Math.pow(d, 2));
		double t1=Tm+Th;
		double t2=Tm-Th;
		if(t1>0)
		{
			Vector k1= new Vector(v.scalar(t1));
			Point3D P1=new Point3D (R.getP00().add_vector(k1));
			list_intersection.add(P1);
		}
		if(t2>0){
		Vector k2= new Vector(v.scalar(t2));
		Point3D p2 = new Point3D (R.getP00().add_vector(k2));
		list_intersection.add(p2);
		}
		//return list_intersection;
		if(list_intersection.isEmpty()!=true){
			Map<Geometry,ArrayList<Point3D>> intersections =new HashMap<Geometry,ArrayList<Point3D>> ();
			intersections.put(this,list_intersection);
			return intersections;
			}
			else
			{
				System.out.println("null");
				return null;

			}
	}
	
	
	public Vector get_normal(Point3D p0)
	{
	  Vector v=new Vector(this.p.vec_act(p0));
	  v.normalization();
	  return v;
	}
}