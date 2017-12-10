/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Vector extends Point
{
  private double magnitude;
  private double bearing;
  
  public Vector (double x, double y, boolean rectangular) 
/*x doubles as magnitude, and y as the bearing, whenever it is not called in rectangular
  circumvents the issue of constructors having the same parameters
*/  
  {
    super(x,y);
    if (rectangular) {
        this.magnitude = Math.hypot(x,y);
        this.bearing = Math.atan(y/x);
    } else {
        this.magnitude = x;
        this.bearing = y;
        this.x = Math.cos(y) * x;
        this.y = Math.sin(y) * x;
    }
    
  }
  
  public double getBearing()
  {
    return bearing;
  }
  public double getMagnitude()
  {
      return magnitude;
  }
  
  public void setBearing(double bearing)
  {
      this.bearing = bearing;
      this.x = Math.cos(bearing) * magnitude;
      this.y = Math.sin(bearing) * magnitude;
  }
  
  public void setMagnitude(double magnitude)
  {
      this.magnitude = magnitude;
      this.x = Math.cos(bearing) * magnitude;
      this.y = Math.sin(bearing) * magnitude;
  }
  @Override
  public void setX(double x)
  {
      this.x = x;
      this.magnitude = Math.hypot(x, y);
      this.bearing = Math.atan(y/x);
  }
  @Override
  public void setY(double y)
  {
      this.y = y;
      this.magnitude = Math.hypot(x,y);
      this.bearing = Math.atan(y/x);
      
  }
   
  
}

