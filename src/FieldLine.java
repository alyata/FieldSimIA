
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
    private boolean direction; //tentative, please reconsider using a direction
    
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
