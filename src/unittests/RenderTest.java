package unittests;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;
import elements.*;

public class RenderTest {
	@Test
	public void basicRendering(){
		Camera cem=new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1));
		Color Background=new Color(0, 0, 0);
		AmbientLight Ambientlight=new AmbientLight(new Color(255,255,255),1);
		Geometries geometries = new Geometries();
		geometries.add(new Sphere(50, new Point3D(0, 0, 150),new Color(34,70,166), new Material(0,0,0)));
	
		geometries.add(new Triangle(new Point3D( 100, 0, 149),
				 							new Point3D(  0, 100, 149),
				 							new Point3D( 100, 100, 149),new Color(0,255,0),new Material(0,0,0)));
		
		geometries.add(new Triangle(new Point3D( 100, 0, 149),
				 			 				new Point3D(  0, -100, 149),
				 			 				new Point3D( 100,-100, 149), new Color(0,0,255),new Material(0,0,0)));
		
		geometries.add(new Triangle(new Point3D(-100, 0, 149),
				 							new Point3D(  0, 100, 149),
				 							new Point3D(-100, 100, 149),new Color(255,0,0),new Material(0,0,0)));
		
		geometries.add(new Triangle(new Point3D(-100, 0, 149),
				 			 				new Point3D(  0,  -100, 149),
				 			 				new Point3D(-100, -100, 149),new Color(0,255,0),new Material(0,0,0)));
		ArrayList<LightSource> _lights=null;
		Scene scene=new Scene("Test scene",geometries,cem,100,Background,Ambientlight,_lights);
		
		ImageWriter imageWriter = new ImageWriter("test0", 500, 500, 500, 500);
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		render.getImagewriter().writeToimage();
	}
/*	@Test
	public void SpotLightTest(){
		Scene scene=new Scene("Test Scene3");
		scene.setCem(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.setDistence(350);
		scene.setBackground(new Color(0, 0, 0));
		scene.setAmbientlight(new AmbientLight(new Color(255,255,255),1));
		Geometries geometries = new Geometries();
		geometries.add(new Sphere(50, new Point3D(0, 0, 150),new Color(34,70,166), new Material(2,0.4,2)));
		scene.get_lights().add((LightSource) new SpotLight(new Color(30,30,30),new Point3D(250,250,250),1.0,0.31,0.4,1.0,new Vector(-4,-9,-2)));
		//scene.set_lights(new SpotLight(new Point3D(250,250,250),1,0.31,0.4,new Color(30,30,30),new Vector(-4,-9,-2)));
		//Scene scene=new Scene("Test scene",geometries,cem,100,Background,Ambientlight,_lights);
		
		ImageWriter imageWriter = new ImageWriter("test1", 500, 500, 500, 500);
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		render.getImagewriter().writeToimage();
	}
	@Test
	public void DirectionalLightTest(){
		Scene scene=new Scene("Test Scene3");
		scene.setCem(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.setDistence(350);
		scene.setBackground(new Color(0, 0, 0));
		scene.setAmbientlight(new AmbientLight(new Color(255,255,255),1));
		Geometries geometries = new Geometries();
		geometries.add(new Sphere(50, new Point3D(0, 0, 150),new Color(34,70,166), new Material(2,0.4,2)));
		scene.get_lights().add( (LightSource) new DirectionalLight(new Color(30,30,30),new Vector(-4,-9,-2)));
		//scene.set_lights(new SpotLight(new Point3D(250,250,250),1,0.31,0.4,new Color(30,30,30),new Vector(-4,-9,-2)));
		//Scene scene=new Scene("Test scene",geometries,cem,100,Background,Ambientlight,_lights);
		
		ImageWriter imageWriter = new ImageWriter("test2", 500, 500, 500, 500);
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		render.getImagewriter().writeToimage();
	}
	@Test
	public void PointLightTest(){
		Scene scene=new Scene("Test Scene3");
	
		scene.setCem(new Camera(new Point3D(0, 0, 0), new Vector(0, -1, 0), new Vector(0, 0, 1)));
		scene.setDistence(350);
		scene.setBackground(new Color(0, 0, 0));
		scene.setAmbientlight(new AmbientLight(new Color(255,255,255),1));
		Geometries geometries = new Geometries();
		geometries.add(new Sphere(50, new Point3D(0, 0, 150),new Color(34,70,166), new Material(2,0.4,2)));
		scene.get_lights().add((LightSource) new PointLight(new Color(30,30,30),new Point3D(250,250,250),1.0,0.31,0.4,1.0));
		//scene.set_lights(new SpotLight(new Point3D(250,250,250),1,0.31,0.4,new Color(30,30,30),new Vector(-4,-9,-2)));
		//Scene scene=new Scene("Test scene",geometries,cem,100,Background,Ambientlight,_lights);
		
		ImageWriter imageWriter = new ImageWriter("test3", 500, 500, 500, 500);
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		render.getImagewriter().writeToimage();
	}
	*/
}
