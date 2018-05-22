package scene;
import java.util.ArrayList;
import java.util.List;

import primitives.*;
import elements.AmbientLight;
import elements.Camera;
import elements.Light;
import elements.LightSource;
import geometries.*;
public class Scene {
	private String NameScene;
	private Geometries listofgeom;
	private Camera camera;
	private double distence;
	private Color background;
	private AmbientLight ambientlight;
	private List<LightSource>_lights;
	
	//*constructors*//
	
	public Scene(String nameScene) {
		this.NameScene = nameScene;
		this.listofgeom=new Geometries();
		this.camera =null;
		this.distence = 0;
		this.background=new Color();
		this.ambientlight=new AmbientLight();
		this._lights=new ArrayList<LightSource>();
	}
	
	public Scene(String nameScene,Geometries list,Camera camera,double d,Color background, AmbientLight amb,ArrayList<LightSource> _lights){
		this.NameScene=nameScene;
		this.listofgeom=list;
		this.camera=camera;
		this.distence=d;
		this.background=background;
		this.ambientlight=amb;
		this._lights=new ArrayList<LightSource>();
	}
	
	/*public Scene() {
		super();
		this.NameScene =null;
		this.listofgeom=new Geometries();
		this.camera =null;
		this.distence = 0;
		this.background=new AmbientLight();
	}*/
	
	
	
	
	//*getters and setters*//
	
	public Geometries getListofGeom() {
		return this.listofgeom;
	}
	public void setListofGeom(Geometries g) {
		this.listofgeom =g;
	}
	public Camera getCem() {
		return camera;
	}
	public void setCem(Camera cem) {
		this.camera = cem;
	}
	public double getDistence() {
		return distence;
	}
	public void setDistence(double distence) {
		this.distence = distence;
	}
	
	public Color getBackground(){
		return this.background;
	}
	public void setBackground(Color back){
		this.background=back;
	}
	
	public AmbientLight getAmbientlight()
	{
		return this.ambientlight;
	}
	
	public void setAmbientlight(AmbientLight amb)
	{
		this.ambientlight=amb;
	}
	
	public List<LightSource> get_lights() {
		return _lights;
	}

	public void set_lights(List<LightSource> _light) {
		this._lights = _light;
	}

	//*function*//
	public void addGeometry(Geometry geomtry){
	 this.listofgeom.add(geomtry);
	}
}