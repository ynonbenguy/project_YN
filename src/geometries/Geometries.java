package geometries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import primitives.*;

public class Geometries extends Geometry {
		private ArrayList<Geometry> itsGeometries;
		
		//*default constructor*//
		
		public Geometries (){
			this.itsGeometries = new ArrayList<Geometry>();
		}
		
		//*operations*//
		public void add(Geometry g) {
			itsGeometries.add(g);
		}
		
		public Vector get_normal(Point3D point){
			return null;
		}
		
		public Map<Geometry,ArrayList<Point3D>> findIntersections(Ray R){
			Map<Geometry,ArrayList<Point3D>> intersectionPoints =new HashMap<Geometry,ArrayList<Point3D>> ();
			
			for (Geometry g: itsGeometries) {
				if(g.findIntersections(R)!=null){
				Map<Geometry,ArrayList<Point3D>> geometryIntersectionPoints =new HashMap<Geometry,ArrayList<Point3D>> ();
				geometryIntersectionPoints.putAll(g.findIntersections(R));
				intersectionPoints.putAll(geometryIntersectionPoints);
				}
			}
			if(intersectionPoints.isEmpty()==true)
			{
				return null;
			}
		else{
				return intersectionPoints;
			}
			
			
		}
}


