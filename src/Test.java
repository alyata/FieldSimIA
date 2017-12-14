import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Simulation wtf = new Simulation("wtf", new Point(100,100));
        wtf.addParticle(new Particle("1", 1, 10, 1, new Point(10, 10)));
        wtf.addParticle(new Particle("2", 1, -10, 1, new Point(60,10)));
        wtf.addFieldLine(new Point(20,10));
        for(Vector sample : wtf.getFieldLine(0).getVectors()) {
            System.out.println(sample.toString());
        }
        
        try {
            //open up standard input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
    }
    
}
