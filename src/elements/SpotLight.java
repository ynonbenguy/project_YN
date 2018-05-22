package elements;
import primitives.*;

public class SpotLight extends PointLight  {

	private Vector direction;

	//*getters and setters*//
	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}

	
	//*constructor*//
	public SpotLight(Color col, Point3D position, double k_C, double k_L, double k_q, double d, Vector direction) {
		super(col, position, k_C, k_L, k_q, d);
		this.direction = direction;
	}
	
	public Color getIntensity(Point3D P)
	{
		double distasnce= P.distance(position);
		double num=k_C+k_L*distasnce+k_q*(Math.pow(distasnce, 2));
		Color intensity=new Color(color.reduce(num));
		double num2=(this.get_L(P)).dot_product(this.get_D(P));
		return( new Color(intensity.scale(num2)));
	}
	
	
}
