package elements;

import primitives.*;
 public class PointLight extends Light{

	 protected Point3D position;
	 protected double k_C;
	 protected double k_L;
	 protected double k_q;
	 
	 //*constructors*//
	 public PointLight(Color col, Point3D position, double k_C, double k_L, double k_q,double d) {
		super(col);
		position = position;
		k_C = k_C;
		k_L = k_L;
		k_q = k_q;
			}
	 
	 
	//*getters and setters*//
	public Point3D getPosition() {
		return position;
	}
	public void setPosition(Point3D position) {
		position = position;
	}
	public double getK_C() {
		return k_C;
	}
	public void setK_C(double k_C) {
		k_C = k_C;
	}
	public double getK_L() {
		return k_L;
	}
	public void setK_L(double k_L) {
		k_L = k_L;
	}
	public double getK_q() {
		return k_q;
	}
	public void setK_q(double k_q) {
		k_q = k_q;
	}

	
	public Vector get_L(Point3D P)
	{
		Vector L=new Vector(this.position.vec_act(P));
		L.normalization();
		return L;
	}
	
	public Vector get_D(Point3D P)
	{
		return(get_L(P));
	}
	public Color getIntensity(Point3D P)
	{
		double distance= P.distance(position);
		double num=k_C+k_L*distance+k_q*(Math.pow(distance, 2));
		Color intensity=new Color(color.reduce(num));
		return intensity;
	}
	
}
