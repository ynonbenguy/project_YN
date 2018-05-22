package elements;
import primitives.*;

public class DirectionalLight extends Light {

	private Vector direction;


	public void set_D(Vector direction) {
		this.direction = direction;
	}
	public Vector get_D(Point3D P)
	{
		return direction;
	}
	
	public Vector get_L(Point3D P)
	{
		return (this.get_D( P));
	}
	public DirectionalLight(Color color,Vector dir)
	{
		super(color);
		direction=dir;
	}
	public DirectionalLight(){
		super();
		this.direction=new Vector();
	}
	public Color getIntensity(Point3D P)
	{
		return color;
	}
}
