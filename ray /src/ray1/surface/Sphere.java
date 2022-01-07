package ray1.surface;

import ray1.IntersectionRecord;
import ray1.Ray;
import egl.math.Vector3;
import egl.math.Vector3d;
import egl.math.Vector2d;
/**
 * Represents a sphere as a center and a radius.
 *
 * @author ags
 */
public class Sphere extends Surface {
  
  /** The center of the sphere. */
  protected final Vector3 center = new Vector3();
  public void setCenter(Vector3 center) { this.center.set(center); }
  
  /** The radius of the sphere. */
  protected float radius = 1.0f;
  public void setRadius(float radius) { this.radius = radius; }
  
  protected final double M_2PI = 2 * Math.PI;
  
  public Sphere() { }
  
  /**
   * Tests this surface for intersection with ray. If an intersection is found
   * record is filled out with the information about the intersection and the
   * method returns true. It returns false otherwise and the information in
   * outRecord is not modified.
   *
   * @param outRecord the output IntersectionRecord
   * @param ray the ray to intersect
   * @return true if the surface intersects the ray
   */
  public boolean intersect(IntersectionRecord outRecord, Ray rayIn) 
  {
	  // TODO#A2: fill in this function.
	  
	  Vector3d d = new Vector3d(rayIn.direction); 
	  Vector3d p = new Vector3d(rayIn.origin); 
	  Vector3d c = new Vector3d(this.center);


	  p.sub(c);
	  double dp = d.dot(p);
	  double dd = d.lenSq();
	  double pp = p.lenSq();
	  
	  double discriminate = dp * dp - dd * (pp - this.radius*this.radius);
	  
	  if(discriminate >= 0)
	  {
		  
		  double t = 0;
		  double t1 = (-1 * d.clone().dot(p) - Math.pow(discriminate, 0.5))/d.clone().lenSq();
		  double t2 = (-1 * d.clone().dot(p) + Math.pow(discriminate, 0.5))/d.clone().lenSq();
		  
		  if (t1 < rayIn.end && t1 > rayIn.start) 
		  {
			  t = t1;
		  }
		  else if (t2 > rayIn.start && t2 < rayIn.end) 
		  {
			  t = t2;
		  } 
		  else 
		  {
			  return false;
		  }
		  
		  
		  Vector3d location = new Vector3d();
		  rayIn.evaluate(location, t);
		 
		  
		  Vector3d norm = new Vector3d();
		  norm.add(c.x, c.y, c.z).sub(location);
		  norm.negate();

		  double phi = Math.acos(norm.y/this.radius);
		  double theta = Math.atan2(norm.x, norm.z);

		  double xTex = (theta+Math.PI)/(Math.PI*2);
		  double yTex = (Math.PI-phi)/Math.PI;

		  outRecord.location.set(location);
		  outRecord.normal.set(norm.normalize());
		  outRecord.texCoords.set(new Vector2d(xTex, yTex));
		  outRecord.t = t;
		  outRecord.surface = this;
		  
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
  /**
   * @see Object#toString()
   */
  public String toString() {
    return "sphere " + center + " " + radius + " " + shader + " end";
  }

@Override
public void computeBoundingBox() {
	// TODO Auto-generated method stub
	
}

}