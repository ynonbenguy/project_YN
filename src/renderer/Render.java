package renderer;
import scene.*;


 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import elements.LightSource;
import primitives.*;
import geometries.*;

public class Render {
private Scene scene;
private ImageWriter imagewriter;




//*constructor*//

public Render(Scene scene, ImageWriter imagewriter) {
	this.scene = scene;
	this.imagewriter = imagewriter;
}

//*getters and setters*//

public Scene getScene() {
	return scene;
}

public void setScene(Scene scene) {
	this.scene = scene;
}

public ImageWriter getImagewriter() {
	return imagewriter;
}

public void setImagewriter(ImageWriter imagewriter) {
	this.imagewriter = imagewriter;
}

//*functions*//

public Map<Geometry,Point3D> getClosestPoint(Map<Geometry,ArrayList<Point3D>> intersectionPoints)
{
	double  min=Double.MAX_VALUE;
	Map<Geometry,Point3D> point=new HashMap<Geometry,Point3D>();
	for(Entry<Geometry, ArrayList<Point3D>> p: intersectionPoints.entrySet() )
	{
		Geometry key=p.getKey();
		ArrayList<Point3D> array=p.getValue();
		for(Point3D poit:array)
		{
			double d=poit.distance(scene.getCem().getP0());
			if(d<min)
			{
				min=d;
				point.clear();
				point.put(key, poit);
			}
		}
	}
	return point;
}
		


public Color  calcColor(Geometry geometry,Point3D point)
{
	Color color= new Color(scene.getAmbientlight().getIntensity(point));
	color.add(geometry.getEmission());
	Vector vec=point.vec_act(scene.getCem().getP0());
	Vector n=geometry.get_normal(point);
	int nShininiess=geometry.getnShininess();
	double Kd=geometry.getMaterail().get_Kd();
	double Ks=geometry.getMaterail().get_Ks();
	for (LightSource lights: scene.get_lights()){
		Vector L=lights.getL();
		if((n.scalar(n.dot_product(L)).dot_product(vec))>0){
			Color lightIntensity=lights.getIntennsity(point);
			color.add(calcDiffusive(Kd,L,n,lightIntensity),calcSpecular(Ks,L,n,vec,nShininiess,lightIntensity));
		}
	}
	return color;
}


public void printGrid(int interval) // assuming that interval is between the lines of the grid
{
	for(int i=0;i<imagewriter.getWidth();i++)
	{
		for(int j=0;j<imagewriter.getHeight();j++)
		{
			if(i%interval==0||j%interval==0)
			{
				imagewriter.writePixel(i, j, 255,255,255);
			}
			else
			{
				imagewriter.writePixel(i, j, 0,0,0);
			}
		}
	}
}
public void renderImage()
{
	
	for(int i=0;i<imagewriter.getNx();i++)
	{
		for(int j=0;j<imagewriter.getNy();j++)
		{
			Ray ray=scene.getCem().construct_Ray_pixel(imagewriter.getNx(), imagewriter.getNy(), i, j, scene.getDistence(), imagewriter.getWidth(), imagewriter.getHeight());
			
			Map<Geometry,ArrayList<Point3D>>  intersectionsPoints=new HashMap<Geometry,ArrayList<Point3D>> ();
			Map<Geometry,Point3D> closestPoint= getClosestPoint(intersectionsPoints);
			if(intersectionsPoints.values().isEmpty() || intersectionsPoints == null || closestPoint == null)
			{
				imagewriter.writePixel(i, j, scene.getBackground().getColor());
			}
			else
			{
				Geometry geometry=(Geometry) closestPoint.keySet().toArray()[0];
				Point3D point=(Point3D) closestPoint.values().toArray()[0];
				imagewriter.writePixel(i, j, calcColor(geometry,point).getColor());
				/*intersectionsPoints.putAll(scene.getListofGeom().findIntersections(ray));
				Geometry geo=null;
				Point3D p=null;
				closestPoint.putAll(getClosestPoint(intersectionsPoints));
				for(Entry<Geometry,Point3D> s : closestPoint.entrySet()) {
					geo =s.getKey();
					p =s.getValue();
				}*/
				System.err.println(i+"/"+imagewriter.getNx());
				
			}
		}
	}
}
public Color calcDiffusive(double Kd, Vector L,Vector n,Color lightIntensity){
	return lightIntensity.scale(Kd*Math.abs(L.dot_product(n)));
}
public Color calcSpecular(double Ks,Vector L, Vector n, Vector v,int nShininiess, Color lightIntensity){
	Vector r=L.add_vector(n.scalar(2*(L.dot_product(n))).normalization());
	return (lightIntensity.scale(Ks*Math.pow(Math.abs(r.dot_product(v)), nShininiess)));
	
}
}