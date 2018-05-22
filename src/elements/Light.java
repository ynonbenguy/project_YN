package elements;
import primitives.*;

public abstract class Light {

	protected Color color;
	
	public abstract Color getIntensity(Point3D P);
	public abstract Vector get_D(Point3D P);
	public abstract Vector get_L(Point3D P);

	public Light(Color col)
	{
		color=col;
	}
	public Light()
	{
		color=new Color();
	}
	
	//*getters and setters*//
	public Color getColor() {
		return new Color(color);
	}

	public void setColor(Color color) {
		color = color;
	}
	
	
}
