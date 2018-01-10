
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public class FieldLine 
{
    private final ArrayList<Vector> vectors;
    private Point startPoint;
    private Point endPoint;
    private final boolean reversedDirection; //use for rendering purposes, to determine actual direction, consequence of the constructor
    
    public FieldLine(Point unitPoint, Particle[] particles, Point boundaries)
    //refer to field line construction algorithm criterion B
    {
        
         vectors = new ArrayList<>();
         this.startPoint = unitPoint;
         double forceAngle = particles[0].getFieldStrength(unitPoint).add(particles[1].getFieldStrength(unitPoint)).getBearing(); //calculates the initial force bearing based on the fields
         Vector testVector = new Vector(3, forceAngle, false);
         this.reversedDirection = unitPoint.add(testVector).distanceFrom(particles[0].getPosition()) < particles[0].getRadius(); 
            //tests if the vector collides with the origin particle or not, which is a check on whether or not to reverse the direction
         if (reversedDirection) 
         { //reverses the angle if the vector immediately collides, prevents premature end
             
             forceAngle = forceAngle + Math.PI;
             Vector line = new Vector(1,0, false);
             while (unitPoint.distanceFrom(particles[0].getPosition()) >= particles[0].getRadius() && unitPoint.distanceFrom(particles[1].getPosition()) >= particles[1].getRadius() && unitPoint.getX() < boundaries.getX() && unitPoint.getY() < boundaries.getY())
             {
                
                line.setBearing(forceAngle);
                vectors.add(new Vector(line.getX(), line.getY(), true));
                System.out.println(unitPoint.add(new Vector(line.getX(), line.getY(), true))); //debugging purposes only REMOVE AFTERWARDS
                unitPoint = unitPoint.add(line);
                forceAngle = particles[0].getFieldStrength(unitPoint).add(particles[1].getFieldStrength(unitPoint)).getBearing() + Math.PI; //calculates the force bearing based on the fields
             }
             this.endPoint = unitPoint;
         } else {
            Vector line = new Vector(1,0, false);
            
             while (unitPoint.distanceFrom(particles[0].getPosition()) >= particles[0].getRadius() && unitPoint.distanceFrom(particles[1].getPosition()) >= particles[1].getRadius() && unitPoint.getX() < boundaries.getX() && unitPoint.getY() < boundaries.getY())
             {
                
                line.setBearing(forceAngle);
                vectors.add(new Vector(line.getX(), line.getY(), true));
                System.out.println(unitPoint.add(new Vector(line.getX(), line.getY(), true))); //debugging purposes only REMOVE AFTERWARDS
                unitPoint = unitPoint.add(line);
                Vector test = particles[1].getFieldStrength(unitPoint);//debugging purposes only
                forceAngle = particles[0].getFieldStrength(unitPoint).add(test).getBearing(); //calculates the force bearing based on the fields
             }
             this.endPoint = unitPoint;
         }
        
    }
    
    public void addVector(Vector newVector) 
    {
        vectors.add(newVector);
    }
    
    public void removeVector(int index)
    {
        vectors.remove(index);
    }
    
    public Vector getVector(int index)
    {
        return vectors.get(index);
    }
    
    public ArrayList<Vector> getVectors()
    {
        return vectors;
    }
    
    public void setStartPoint(Point newStart)
    {
        startPoint = newStart;
    }
    
    public Point getStartPoint()
    {
        return startPoint;
    }
    
    public void setEndPoint(Point newEnd)
    {
        endPoint = newEnd;
    }
    
    public Point getEndPoint()
    {
        return endPoint;
    }
}
