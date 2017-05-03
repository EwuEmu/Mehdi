//Mehdi Idrissi
//4/5
//Lab 3 Multithreading

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import javax.imageio.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Random;

public class MainBoss 
{
	
   private int xLeft;
   private int yTop;
   private int xPoint;
   private int yPoint;
   private int animateCounter;
   
   private int delay;
   private boolean shoot;
   private JComponent component;
   /**
      Creates a new MovingCarInstance
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
      @param step Step in pixels the car will move each time
      @param delay The delay to wait between each step
      @param steps How many times the car will move
      @param direction In which direction the car will move
      @param component The component
    */	
	 public MainBoss(int x, int y,int delay, boolean fire, JComponent component) 
	 {
	    xLeft = x;
	    yTop = y;
	    this.delay = delay;
	    shoot = fire;
	    this.component = component;
	    animateCounter = 0;
   	 }
   
   /**
      Moves the car.
      @param dx the amount to move in x-direction
      @param dy the amount to move in y-direction
   */
   public void move(double dx, double dy)
   {
      xPoint += dx;
      yPoint += dy;
   }
    
   
   /**
    * Adjusts the car's x and y locations based on the direction it is going.  Moves it a fixed
    * number of steps.
    */
   public void animate()
         throws InterruptedException
   {
         int x = 5;
         int y = 5;
                  
         move(x, y);
         pause();

   }

   /**
      Draws the car.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {    
//      Ellipse2D.Double frontTire = new Ellipse2D.Double(xLeft, yTop, 50, 50);
//      g2.fill(frontTire);
//      g2.draw(frontTire);
//		BufferedImage background = null;
		BufferedImage boss0 = null;
		BufferedImage boss1 = null;
		BufferedImage boss2 = null;
		BufferedImage boss3 = null;
		BufferedImage boss4 = null;
		BufferedImage boss5 = null;
		try
		{
//	   		background = ImageIO.read(new File("icebackground.png"));
	   		boss0 = ImageIO.read(new File("iceboss.png"));
	   		boss1 = ImageIO.read(new File("iceAnimate1.png"));
	   		boss2 = ImageIO.read(new File("iceAnimate2.png"));
	   		boss3 = ImageIO.read(new File("iceAnimate3.png"));
	   		boss4 = ImageIO.read(new File("iceAnimate4.png"));	  
	   		boss5 = ImageIO.read(new File("iceAnimate5.png"));	   			 			   		
		} 
		catch (IOException e) {}
		
//		g2.setColor(new Color(130,171,172));
//      g2.fill(new Rectangle2D.Double(0,0,1920,1000));
		
//		g2.drawImage(background,0,0, null);
		
		if (animateCounter < 70)		
		g2.drawImage(boss0, 780,300, null);
		else if (animateCounter < 75)
		g2.drawImage(boss1, 780,300, null);
		else if (animateCounter < 85)
		g2.drawImage(boss2, 780,300, null);
		else if (animateCounter < 100)
		g2.drawImage(boss3, 780,300, null);			
		else if (animateCounter < 115)
		g2.drawImage(boss4, 780,300, null);
		else if (animateCounter < 130)
		g2.drawImage(boss5, 780,300, null);	
		//breathe in
		else if (animateCounter < 140)
		g2.drawImage(boss4, 780,300, null);
		else if (animateCounter < 150)
		g2.drawImage(boss3, 780,300, null);
		else if (animateCounter < 155)
		g2.drawImage(boss2, 780,300, null);			
		else if (animateCounter < 160)
		g2.drawImage(boss1, 780,300, null);
		else
		{
		g2.drawImage(boss0, 780,300, null);				
		animateCounter = 0;	
		}	
			
						
		animateCounter++;

   }

   
   /**
      Pauses the animation.
   */
   public void pause()
         throws InterruptedException
   {
      component.repaint();
      Thread.sleep(delay);
   }
   

}
