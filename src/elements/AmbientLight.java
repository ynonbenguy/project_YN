package elements;
import primitives.*;


public class AmbientLight extends Light {
private double k_a;
private Color intensity;


//*getters and setters*//


public double getK_a() {
	return k_a;
}

public void setK_a(double k_a) {
	this.k_a = k_a;
}

//*constructors*//

public AmbientLight(Color color,double k)
{
	super(color);
	this.k_a=k;
	intensity=new Color(this.color.scale(k));
}

public AmbientLight()
{
	super();
	this.k_a=0;
	intensity=new Color(this.color.scale(k_a));
}

//get_intensity()
public Color getIntensity(Point3D P)
{
	return intensity;
}

@Override
public Vector get_D(Point3D P) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Vector get_L(Point3D P) {
	// TODO Auto-generated method stub
	return null;
}
}
