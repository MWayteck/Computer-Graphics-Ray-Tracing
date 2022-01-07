package ray1.shader;

import egl.math.Colorf;
import ray1.IntersectionRecord;
import ray1.Ray;
import ray1.Scene;

/**
 * A Lambertian material scatters light equally in all directions. BRDF value is
 * a constant
 *
 * @author ags, zechenz
 */
public class Lambertian extends ReflectionShader {

	/** The diffuse reflectance of the surface. */
	protected final Colorf diffuseColor = new Colorf(0.2f, 0.2f, 0.2f);
	public void setDiffuseColor(Colorf inDiffuseColor) { diffuseColor.set(inDiffuseColor); }
	public Colorf getDiffuseColor() {return new Colorf(diffuseColor);}

	public Lambertian() { }

	@Override
	public String toString() {
		return "lambertian: " + diffuseColor;
	}
	
	@Override
	public void init() {
		LambertianBRDF brdf = new LambertianBRDF(diffuseColor, texture);
		this.brdf = brdf;
	}
	@Override
	public void shade(Colorf outIntensity, Scene scene, Ray ray, IntersectionRecord record) {
		// TODO Auto-generated method stub
		
	}


}
