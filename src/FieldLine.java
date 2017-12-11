
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
    private ArrayList<Vector> vectors;
    private Point startPoint;
    private Point endPoint;
    private boolean reversedDirection; //use only for rendering purposes, to determine actual direction, consequence of the constructor
    
    public FieldLine(Point unitPoint)
    //refer to field line construction algorithm criterion B
    {
        /*
         vectors = new ArrayList<Vector>;
         this.startPoint = unitPoint;
         double forceAngle = initAngle(); calculates the initial force bearing based on the fields
         Vector testVector = new Vector(single unit of measure, forceAngle, false);
         if (testVector collides) 
         { //reverses the angle if the vector immediately collides, prevents premature end
             reversedDirection = true;
             forceAngle += 180.0;
             Vector line = new Vector(0,0, false);
             while (startPoint.add(line) in bounds)
             {
                line.setMagnitude(single unit of measure);
                line.setBearing(forceAngle);
                vectors.add(line);
                unitPoint.add(new Point(line.getX(),line.getY()));
                forceAngle = initAngle()+180.0; calculates the force bearing based on the fields
             }
             this.endPoint = unitPoint;
         } else {
            Vector line = new Vector(0,0, false);
            reversedDirection = false;
             while (startPoint.add(line) in bounds)
             {
                line.setMagnitude(single unit of measure);
                line.setBearing(forceAngle);
                vectors.add(line);
                unitPoint.add(new Point(line.getX(),line.getY()));
                forceAngle = initAngle(); calculates the force bearing based on the fields
             }
             this.endPoint = unitPoint;
         }
        */
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
