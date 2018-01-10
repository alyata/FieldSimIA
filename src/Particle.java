/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Particle 
{

    
    private String name;
    private Vector velocity;
    private Vector force;
    private double mass;
    private double charge;
    private double radius;
    private Point position; //absolute position of the particle within the simulation
    public static final double COULOMB = 8987551787.3681764; //coulomb's constant for use in field calculations
    
    public Particle(String name, double mass, double charge, double radius, Point position)
    {
        this.name = name;
        this.charge = charge;
        this.mass = mass;
        this.radius = radius;
        //initial velocity and force are set to 0, as is the common case when a new particle enters the simulation
        velocity = new Vector(0,0,true);
        force = new Vector(0,0,true);
        this.position = position;
    }

    public double getRadius() {
        return radius;
    }

    public String getName()
    {
        return name;
    }
    
    public double getMass()
    {
        return mass;
    }
    
    public double getCharge()
    {
        return charge;
    }
    
    public Vector getForce()
    {
        return force;
    }
    
    public Vector getVelocity()
    {
        return velocity;
    }
    
    public Point getPosition()
    {
        return position;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setMass(double mass)
    {
        this.mass = mass;
    }
    
    public void setCharge(double charge)
    {
        this.charge = charge;
    }
    
    public void setForce(Vector force)
    {
        this.force = force;
    }
    
    public void setVelocity(Vector velocity)
    {
        this.velocity = velocity;
    }
    
    public void setPosition(Point position)
    {
        this.position = position;
    }
    
    public void setRadius(double radius) 
    {
        this.radius = radius;
    }
    
    //returns the field strength caused by the particle at an absolute point using coulomb's law, useful in determining the vectors within a fieldline.
    public Vector getFieldStrength(Point testPosition)
    {
        double bearing = position.bearingFrom(testPosition);
        if (charge > 0) //tests for the direction of the field, if positive the direction is away, hence the reverse direction
        {
            bearing = bearing + Math.PI;
        }
        return new Vector(COULOMB * Math.abs(charge)/Math.pow(position.distanceFrom(testPosition), 2), bearing, false);
    }
}


