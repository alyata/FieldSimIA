
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Simulation 
{   
    private String name;
    private Particle[] particles;
    private int particleCount;
    private ArrayList<FieldLine> field;
    private Point boundaries;

    public Simulation(String name, Point boundaries)
    {
        particles = new Particle[2];
        field = new ArrayList<>();
        this.name = name;
        this.boundaries = boundaries;
        particleCount = 0;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the particles
     */
    public Particle[] getParticles() {
        return particles;
    }

    /**
     * @param particles the particles to set
     */
    public void setParticles(Particle[] particles) {
        this.particles = particles;
    }

    /**
     * @return the field
     */
    public ArrayList<FieldLine> getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(ArrayList<FieldLine> field) {
        this.field = field;
    }

    /**
     * @return the boundaries
     */
    public Point getBoundaries() {
        return boundaries;
    }

    /**
     * @param boundaries the boundaries to set
     */
    public void setBoundaries(Point boundaries) {
        this.boundaries = boundaries;
    }
    
    /**
     * @return the particleCount
     */
    public int getParticleCount() {
        return particleCount;
    }
    
    public Particle getParticle(int index)
    {
        return particles[index];
    }
    
    public FieldLine getFieldLine(int index)
    {
        return field.get(index);
    }
    
    public void removeParticle(int index)
    {
        particles[index] = null;
    }
    
    public void removeFieldLine(int index)
    {
        field.remove(index);
    }
    
    public void addParticle(Particle newParticle)
    {
        if (particleCount < 2 && newParticle.getPosition().getX() < boundaries.getX() && newParticle.getPosition().getY() < boundaries.getY())
            //checks if there are less than 2 particles and if the intended position is within bounds
        {
            particles[particleCount] = newParticle;
            particleCount++;
        }
    }
    
    public void addFieldLine(Point startPoint)
    {
        field.add(new FieldLine(startPoint, particles, boundaries));
    }

    

    
}
