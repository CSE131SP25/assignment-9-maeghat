package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	// creates new food at random location once food is eaten
	public Food() {
		 x = Math.random() * (1 - FOOD_SIZE);
	      y = Math.random() * (1 - FOOD_SIZE);
        }
	 
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		 StdDraw.setPenColor(StdDraw.RED);
	        StdDraw.filledCircle(x, y, FOOD_SIZE / 2);
	        }
	
	
	public double getX() {
	        return x;
	    }

	    public double getY() {
	        return y;
	    }
}
