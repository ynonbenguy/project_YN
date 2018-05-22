package geometries;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import primitives.*;
public class Triangle extends Plane {
	private Point3D p2;
	private Point3D p3;
	
	
	
	//*getters and setters*//
	public Point3D getP2(){
		return p2;
	}
	public void setP2(Point3D p2){
		this.p2=p2;
	}
	public Point3D getP3(){
		return p3;
	}
	public void setP3(Point3D p3){
		this.p3=p3;
	}
	
	//*constructors*//
	public Triangle (Point3D p1,Point3D p2,Point3D p3,Vector v,Color emision,Material material){
		super(p1,v,emision,material);
		this.p2=p2;
		this.p3=p3;
	}
	public Triangle (Point3D p1,Point3D p2,Point3D p3,Color emision,Material material){
		super(p1,p2,p3,emision,material);
		this.p2=p2;
		this.p3=p3;
	}// 3 points
	public Triangle()
	{
		super();
		p2=new Point3D(0,0,0);
		p3=new Point3D(0,0,0);
	}
	private int getExp(double num) {
		return (int)((Double.doubleToRawLongBits(num) >> 52) & 0x7FFL) - 1023;
	}
	
	//*operations*//
	public Map<Geometry,ArrayList<Point3D>> findIntersections(Ray R){
		Vector vec1=new Vector(R.getP00().vec_act((this.p1)));
		double num1=this.V.dot_product(vec1);
		double num2=(this.V).dot_product(R.getDirection());
		double t=num1/num2;
		Vector k=new Vector(R.getDirection().scalar(t));
		Point3D poit=new Point3D(R.getP00().add_vector(k)) ;  
		ArrayList<Point3D> list_intersection=new ArrayList<Point3D>();
		list_intersection.add(poit);//נקודת החיתוך של המישור עם הקרן 
		
		Point3D p0= new Point3D(R.getP00());
		Vector v1= new Vector(p0.vec_act(this.p1));
		Vector v2= new Vector(p0.vec_act(this.p2));
		Vector v3= new Vector(p0.vec_act(this.p3));
		Vector N1= new Vector(v1.cross_product(v2));
		Vector N2= new Vector(v2.cross_product(v3));
		Vector N3= new Vector(v3.cross_product(v1));
		N1.normalization();
		N2.normalization();
		N3.normalization();
		Vector v= new Vector(p0.vec_act(poit));
		num1= v.dot_product(N1);
		num2= v.dot_product(N2);
	    double num3= v.dot_product(N3);
	    if((getExp(num1)<-20)||(getExp(num2)<-20)||(getExp(num3)<-20)){
	    	return null;
	    }
	    else if ((num1>0 && num2>0 && num3>0)||(num1<0 && num2<0 && num3<0)){
		//	return list_intersection;
	    	Map<Geometry,ArrayList<Point3D>> intersections =new HashMap<Geometry,ArrayList<Point3D>> ();
	    	intersections.put(this, list_intersection);
	    	return intersections;
		}
		else {
			return null;
		}
	}
	
	
	public Vector get_normal (Point3D p){
		Vector V1=new Vector(p.vec_act(p2));
		Vector V2=new Vector(p.vec_act(p3));
		Vector V3=new Vector(V1.cross_product(V2));
		V3.normalization();
		return V3;
	}
}