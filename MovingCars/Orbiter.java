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

/**
   A car shape that can be positioned anywhere on the screen.
*/
public class Orbiter
{
   /**
      Constructs a car with a given top left corner
      @param x the x coordinate of the top left corner
      @param y the y coordinate of the top left corner
   */
   public Orbiter(int x, int y)
   {
      xLeft = x;
      yTop = y;
   }

   /**
      Moves the car.
      @param dx the amount to move in x-direction
      @param dy the amount to move in y-direction
   */
   public void move(double dx, double dy)
   {
      xLeft += dx;
      yTop += dy;
   }
   
   public int getX()
   {
   	return xLeft;
   }
   
   public int getY()
   {
   	return yTop;
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

		BufferedImage icicle = null;
		try
		{
	   		icicle = ImageIO.read(new File("icicle.png"));   			 			   		
		} 
		catch (IOException e) {}
		g2.drawImage(icicle,xLeft-15,yTop-15, null);
			   
//      Point2D.Double left = new Point2D.Double(xLeft-15,yTop);
//      Point2D.Double right = new Point2D.Double(xLeft+15,yTop);
//      Point2D.Double top = new Point2D.Double(xLeft,yTop- 30);            
//      Point2D.Double bottom = new Point2D.Double(xLeft,yTop+ 30);
//      
//      Line2D.Double leftTopD = new Line2D.Double(left,top);
//      Line2D.Double rightTopD = new Line2D.Double(right,top);
//      Line2D.Double leftBotD = new Line2D.Double(left,bottom);
//      Line2D.Double rightBotD = new Line2D.Double(right,bottom);
//      
//      Polygon diamond = new Polygon(new int[]{xLeft-10, xLeft, xLeft + 10, xLeft}, new int[]{yTop, yTop+15, yTop, yTop-15}, 4);
//
//      
//      g2.setColor(new Color(29,108,117));
//      g2.draw(leftTopD);
//      g2.draw(rightTopD);
//      g2.draw(leftBotD);      
//      g2.draw(rightBotD);      
//      
//      g2.setColor(new Color(121,227,239));
//      g2.fill(diamond);
      
//		Image img = null;		
//		try
//		{
//	   		img = ImageIO.read(new File("iceboss.png"));
//		} 
//		catch (IOException e) {System.out.println ("not found");}
//		
//		g2.drawImage(img, 680,350, null);
      
                             
   }

   public static int WIDTH = 60;
   public static int HEIGHT = 30;
   private int xLeft;
   private int yTop;
}