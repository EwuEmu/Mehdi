//Mehdi Idrissi
//4/5
//Lab 3 Multithreading

import javax.swing.JComponent;
import java.awt.Graphics2D;
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

public class MovingOrbiter extends Orbiter
{
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
   public MovingOrbiter(int x, int y, int step, int steps,
         int direction, JComponent component)
   {
      super(x, y);
      this.step = step;
      this.delay =  15;//(int)(Math.random()*5 + 1);
      this.steps = steps;
      this.direction = direction;
      fire = false;      
      this.component = component;
      playerX = 1200;
      playerY = 900;
   }
   
   /**
    * Adjusts the car's x and y locations based on the direction it is going.  Moves it a fixed
    * number of steps.
    */
   public void animate()
         throws InterruptedException
   {
      for (int i = 0; i < steps; i++)
      {	 

      	 int radius = 35;
         int x = 0;
         int y = 0;
         
         int rand = (int)(Math.random() * 1500);
         if (rand == 9)
         	fire = true;

         
         if (!fire)
         {
         switch(direction)
         {

            case NORTH:
            	if (i < radius) // FINISH 1/4 OF CIRCLE TURN;
            		y = -2 * step;
            	else if (i < radius * 2)
            	{
            		y = -2 * step;
            		x = step;            	
            	}
            	else if (i < radius * 3)
            	{
            		y = -1 * step;
            		x = step;            	
            	}
            	else if (i < radius * 4)
            	{
            		y = -1 * step;
            		x = 2* step;            	
            	}
            	else if (i >= radius *4)
				   	direction = EAST;  
               break;
            case EAST:
            	if (i < radius *5) // FINISH 1/4 OF CIRCLE TURN;
            		x = 2 * step;
            	else if (i < radius *6)
            	{
            		x = 2 * step;
            		y = step;            	
            	}
            	else if (i < radius *7)
            	{
            		x = 1 * step;
            		y = step;            	
            	}
            	else if (i < radius *8)
            	{
            		x = 1 * step;
            		y = 2* step;            	
            	}
            	else if (i >= radius *8)
				   	direction = SOUTH; 
               break;
            case SOUTH:
             	if (i < radius *9) // FINISH 1/4 OF CIRCLE TURN;
            		y = 2 * step;
            	else if (i < radius *10)
            	{
            		y = 2 * step;
            		x = -1 *step;            	
            	}
            	else if (i < radius *11)
            	{
            		y = step;
            		x = -1 *step;             	
            	}
            	else if (i < radius *12)
            	{
            		y = step;
            		x = -2 *step;            	
            	}
            	else if (i >= radius *12)
				   	direction = WEST; 
               break;
            case WEST:
              	if (i < radius *13) // FINISH 1/4 OF CIRCLE TURN;
            		x = -2 * step;
            	else if (i < radius *14)
            	{
            		x = -2 * step;
            		y = -1 *step;            	
            	}
            	else if (i < radius *15)
            	{
            		x = -1 * step;
            		y = -1 *step;             	
            	}
            	else if (i < radius *16)
            	{
            		x = -1 * step;
            		y = -2 *step;           	
            	}
            	else if (i >= radius *16)
            	{
				   	direction = NORTH;
				   	i = 0;
            	}
         }
         move(x, y);
         pause();
         }
         else if (fire)
         {
     			int xInc = 0;
     			int yInc= 0;
     			int dividend = 0;         	
         	
  

         	boolean notHit = true;
         	
         	
         	while (notHit)
     		{
     			xInc = (playerX - getX());
     			yInc = (playerY - getY());
     				
      			if (xInc >100 || yInc > 100) //setting amount of steps to get to target
     			dividend = 50;
     			else if (xInc >200 || yInc > 200)	
     			dividend = 200;
     			else if (xInc >300 || yInc > 300)	
     			dividend = 300;
     			else
     			dividend = 25;     			

   				
     				      	     			

     			

     			xInc = (int) Math.round(xInc / dividend);
     			yInc = (int) Math.round(yInc/ dividend);
				
     			move(xInc, yInc);
     			playerX = playerX +2;
     			playerY = playerY - 5;
     			pause();
     			
     			
     		}
         }
         

      }
   }
   
    /**
      Draws the car in the current position.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      super.draw(g2);
   }

   public boolean getFired()
   {
      return fire;
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
   
   public static final int NORTH = 1;
   public static final int SOUTH = 2;
   public static final int EAST = 3;
   public static final int WEST = 4;
   
   private int playerX;
   private int playerY;
   private int step;
   private int delay;
   private int steps;
   private int direction;
   private JComponent component;
   private boolean fire;
}
