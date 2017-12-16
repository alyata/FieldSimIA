/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Point //Point class to describe a point in the simulation.
{
  protected double x;
  protected double y;
  
  public Point(double x, double y)
  {
    this.x = x;
    this.y = y;
  }
  public void setX(double x)
  {
    this.x = x;
  }
  public void setY(double y)
  {
    this.y = y;
  }
  
  public double getX()
  {
    return this.x;
  }
  
  public double getY()
  {
    return this.y;
  }
  //adds the coordinates of point other to this point
  public Point add(Point other)
  {
      return new Point(x + other.getX(), y + other.getY());
  }
  //the two methods below are useful for determining field strength in field calculations
  public double distanceFrom(Point other)
  {
      return Math.hypot(x - other.getX(), y = other.getY());
  }
  
  public double bearingFrom(Point other)
  {
      double returned = Math.atan2(y-(other.getY()), (x - other.getX()));
      return returned;
  }
  @Override
  public String toString()
  {
    return "(" + this.x + "," + this.y + ")" ;
  }
}
