package geometries;
import primitives.*;
public class Base {
	public static void main(String[] args)
	{
	Coordinate x=new Coordinate(3);
	Coordinate y=new Coordinate(3);
	Coordinate z=new Coordinate(x.add(y));//çéñåø åçéáåø äééðå äê
	System.out.println(z.toString());


	Point3D p1=new Point3D(3,4,5);// exampels of operations*//
	Vector v1=new Vector(6,7,8);
	Vector V2=new Vector(p1.add_vector(v1));
	System.out.println(V2.toString());

	Point3D p2=new Point3D(1,7,8);
	double d=p1.distance(p2);
	System.out.println(d);

	Vector V3=new Vector(p1.vec_act(p2));
	System.out.println(V3.toString());

	Vector V4=new Vector(v1.add_vector(V3));
	System.out.println(V4.toString());

	Vector V5=new Vector(V3.cross_product(v1));
	System.out.println(V5.toString());
	 
	double m=V5.dot_product(V2);
	System.out.println(m);

	V5.normalization();
	System.out.println(V5.toString());



	}


}
