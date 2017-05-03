//Mehdi Idrissi
//4/5
//Lab 3 Multithreading
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.*;

/**
   This component draws two car shapes.
*/
public class OrbiterComponent extends JComponent
{  
	/**
	 * Adds cars to the component
	 */
   public OrbiterComponent()
   {
   	  size = 14;
   	  boss = new MainBoss(300,500,5,true,this);
   	  runes = new ArrayList<MovingOrbiter>();
   	  threads = new ArrayList<Thread>();
   	  for (int i = 0; i<size; i++)
   	  {
      	runes.add(new MovingOrbiter(700, 450, 1, 2000, MovingOrbiter.NORTH, this));   	  	
   	  }

   
   }
   
   /**
    * Draws the cars
    */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      boss.draw(g2);
	  for (int i = 0; i<runes.size(); i++)
	  	runes.get(i).draw(g2);
   }
   
   /**
      Starts a new animation thread.
   */
   public void startAnimation()
   {
      class AnimationRunnable implements Runnable
      {
         public AnimationRunnable(MovingOrbiter orbiter, MainBoss bosso)
         {
            this.orbiter = orbiter;
            this.bosso = bosso;
         }

         public void run()
         {
            try
            {
               bosso.animate();               
               orbiter.animate();

                //CONTINUE AFTER THIS LINE
            }
            catch (InterruptedException exception)
            {
            }
         }
         private MovingOrbiter orbiter;
         private MainBoss bosso;
      }
	  
	    for (int i = 0; i<size; i++)
	    {
	    	threads.add(new Thread(new AnimationRunnable(runes.get(i), boss))) ;
	    }
	    

	  
//      Runnable r1 = new AnimationRunnable(orbiter1);
//      Runnable r2 = new AnimationRunnable(orbiter2);
//      Runnable r3 = new AnimationRunnable(orbiter3);
//      Runnable r4 = new AnimationRunnable(orbiter4);
//      Thread t1 = new Thread(r1);
//      Thread t2 = new Thread(r2);
//      Thread t3 = new Thread(r3);
//      Thread t4 = new Thread(r4);
      
      try
      {

		for (Thread t: threads)
		{
			t.start();
			Thread.sleep(600);
		}      	
//      t1.start();
//      Thread.sleep(500);
//      t2.start();
//      Thread.sleep(500);
//      t3.start();
//      Thread.sleep(500);
//      t4.start();
//      Thread.sleep(500);       	
      }
      catch (Exception e){}

   }
   
   private ArrayList<MovingOrbiter> runes;
   private ArrayList<Thread> threads;
   private int size;
   private MainBoss boss;

}