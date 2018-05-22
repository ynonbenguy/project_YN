package primitives;
import java.util.ArrayList;

import elements.*;
import scene.*;
import geometries.*;
public class Material {
	protected double  _Kd;
	protected double _Ks;
	int nShininess;
	 //*constructors*//
	public Material(double _Kd, double _Ks, int nShininess) {
		super();
		this._Kd = _Kd;
		this._Ks = _Ks;
		this.nShininess = nShininess;
	}
	public Material(){
		_Kd=0;
		_Ks=0;
	}
	/**getters setters*/
	public double get_Kd() {
		return _Kd;
	}
	public void set_Kd(double _Kd) {
		this._Kd = _Kd;
	}
	public double get_Ks() {
		return _Ks;
	}
	public void set_Ks(double _Ks) {
		this._Ks = _Ks;
	}
	public int getnShininess() {
		return nShininess;
	}
	public void setnShininess(int nShininess) {
		this.nShininess = nShininess;
	}
	/*functions*/
	/*public Color  getIntensity(Point3D point,ArrayList<Light> _light, Geometry geometry,Camera cam){
		for(Light light: _light){
			Vector n=geometry.get_normal(point);
			if ((light.get_L(point).dot_product(n)>0&& cam.getVto().dot_product(n)>0)||(light.get_L(point).dot_product(n)<0&& cam.getVto().dot_product(n)<0)){
			double num=light.get_L(point).dot_product(n)*2;
			Vector vec=geometry.get_normal(point).scalar(num);
			Vector r=light.get_L(point).add_vector(vec);
			double num1=_Kd*(Math.sqrt(light.get_L(point).dot_product(n)*light.get_L(point).dot_product(n)));
			double num2=(Math.sqrt(cam.getVto().dot_product(r)*cam.getVto().dot_product(r)));
			double num3=_Ks*(Math.pow(num2, nShininess));
			Color col =light.getIntensity(point).scale(num3);          	
			}
		}
		Color
		return Ip;
	*/	

}
