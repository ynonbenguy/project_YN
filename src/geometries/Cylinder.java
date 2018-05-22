package geometries;
import primitives.*;


public class Cylinder extends RadialGeometry {
	private double h;
	private Ray Direction;
	public Cylinder(double radious, double h, Ray direction,Color emission,Material material ) {
		super(radious, emission, material);
		this.h = h;
		this.Direction = direction;
	}
	public Cylinder()
	{
		super();
		this.h=0;
		Direction=new Ray();
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public Ray getDirection() {
		return Direction;
	}
	public void setDirection(Ray direction) {
		Direction = direction;
	}
	
}