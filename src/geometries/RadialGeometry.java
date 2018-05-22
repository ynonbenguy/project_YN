package geometries;

import java.util.ArrayList;
import java.util.Map;

import primitives.*;
public class RadialGeometry extends Geometry {
	private double radious;
	
	
	
//*constructors*//
	
	public RadialGeometry(double radious,Color emission,Material material) {
		super(emission,material);
		this.radious = radious;
	}
	public RadialGeometry()
	{
		super();
		this.radious=0;
	}
	public RadialGeometry(RadialGeometry R,Color emission,Material material)
	{
		super(emission,material);
		this.radious=R.getRadious();
	}
	
	//getters and setters*//
	public double getRadious() {
		return this.radious;
	}
	public void setRadious(double radious) {
		this.radious = radious;
	}
	
	
	//*operations*//
	
	public Vector get_normal(Point3D p)
	{
		return null;
	}
	
	public  Map<Geometry,ArrayList<Point3D>> findIntersections(Ray R)
	{
		return null;
	}
	
}

