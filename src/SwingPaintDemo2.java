
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class SwingPaintDemo2 {
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.add(new MyPanel());
        f.pack();
        
    }
}

class MyPanel extends JPanel {

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        Simulation wtf = new Simulation("wtf", new Point(100,100));
        wtf.addParticle(new Particle("1", 1, 10, 1, new Point(10, 10)));
        wtf.addParticle(new Particle("2", 1, -10, 1, new Point(60,10)));
        wtf.addFieldLine(new Point(10 + 1/Math.sqrt(2),10 + 1/Math.sqrt(2)));
        for(Vector sample : wtf.getFieldLine(0).getVectors()) {
            System.out.println(sample.toString());
        }
        g.drawLine(0,0,100,100);
    }  
}
