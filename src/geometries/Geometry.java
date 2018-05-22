package geometries;
import java.util.ArrayList;
import java.util.Map;

import primitives.*;
public abstract class Geometry extends Material{
	
    protected  Color emission;
	protected Material material;
    
    
	public Geometry(Color emission,Material material) {
		this.emission = emission;
		this.material=material;
	}
	public Geometry()
	{
		this.emission=new Color(255,255,255);
		this.material=null;
	}
	public Color getEmission() {
		return emission;
	}
	public void setEmission(Color emission) {
		this.emission = emission;
	}
	public Material getMaterail(){
		return material;
	}
	public void setMaterial(){
		this.material=material;
	}
	//*functions*//
	public abstract Vector get_normal(Point3D p);
	//public abstract ArrayList<Point3D> findIntersections(Ray R);
	public abstract Map<Geometry,ArrayList<Point3D>> findIntersections(Ray y);
}
 
 //322981275
//314623364