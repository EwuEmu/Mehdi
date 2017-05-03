//Mehdi Idrissi
//4/5
//Lab 3 Multithreading
import javax.swing.JFrame;

/**
 * Shows an animation of moving projectiles
 */
public class OrbiterViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 1920;
      final int FRAME_HEIGHT = 1080;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Boss Spawn");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      OrbiterComponent component = new OrbiterComponent();
      frame.add(component);

      frame.setVisible(true);
      component.startAnimation();
   }
}

