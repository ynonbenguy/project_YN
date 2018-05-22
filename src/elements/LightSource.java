package elements;
import primitives.*;

public interface LightSource {
	public Color getIntennsity(Point3D point);
	public Vector getL();
	public Vector getD();

}
