package elements;
import primitives.*;
public class Camera {
private Point3D p0;
private Vector Vup;
private Vector Vto;
private Vector Vright;

//*constructor*//
	public  Camera (Point3D p,Vector Vu ,Vector Vt) /*throws Exception*/
	{
	p0=new Point3D(p.getX(),p.getY(),p.getZ());
	Vup=new Vector(Vu);
	Vto=new Vector(Vt);
	/*double x=(Vu.dot_product(Vt));
	double y=(Vu.length_vec())*(Vt.length_vec());
	double z=x/y;
		if(z!=0.0)
		{
			throw new Exception("Error");
		}
		*/
	Vright=new Vector(Vu.cross_product(Vt));
	}
	
	
	
	//*getters and setters*//
	
	public Point3D getP0() {
		return p0;
	}


	public void setP0(Point3D p0) {
		this.p0 = p0;
	}


	public Vector getVup() {
		return Vup;
	}


	public void setVup(Vector vup) {
		Vup = vup;
	}


	public Vector getVto() {
		return Vto;
	}

	public void setVto(Vector vto) {
		Vto = vto;
	}


	public Vector getVright() {
		return Vright;
	}


	public void setVright(Vector vright) {
		Vright = vright;
	}


//*constructing ray through pixel*//
	public  Ray construct_Ray_pixel(int Nx, int Ny, int i,int j,double screenDistance,double screenWidth,double screenHeight){
	  double Ry=screenHeight/Ny;
	  double Rx=screenWidth/Nx;
	  Vector v=new Vector(this.Vto.scalar(screenDistance));
	  Point3D Pc=new Point3D(p0.add_vector(v));
	  double Yj=(j-(Ny/2.0))*Ry-(Ry/2.0);
	  double Xi=(i-(Nx/2.0))*Rx-(Rx/2.0);
	  Vector XiVright=new Vector (this.Vright.scalar(Xi));
	  Vector YjVup=new Vector (this.Vup.scalar(-Yj));
	  Vector essVector=new Vector(XiVright.add_vector(YjVup));
	  Point3D pij=new Point3D(Pc.add_vector(essVector));
	  Vector direct=new Vector(p0.vec_act(pij));
	  direct.normalization();
	  Ray r=new Ray(p0,direct);
	  return r;
	}
}