package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		    segments = new LinkedList<>();
	        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
	        deltaX = 0;
	        deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		
		double newX = segments.getFirst().getX() + deltaX;
        double newY = segments.getFirst().getY() + deltaY;

        // move each segment to the position of the one in front of it
       //When the snake moves, a new head segment is created at the new position based on the current direction 
        //tail is removed from the list to look like its moving forward
        for (int i = segments.size() - 1; i > 0; i--) {
            BodySegment prev = segments.get(i - 1);
            segments.get(i).setPosition(prev.getX(), prev.getY());
        }

        // move the head
        segments.getFirst().setPosition(newX, newY);
	    }
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		 for (BodySegment seg : segments) {
	            seg.draw();
	        }
		}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {// adds a new body segment to the end of the linked list
		 double headX = segments.getFirst().getX();
	        double headY = segments.getFirst().getY();
	        double dx = headX - f.getX();
	        double dy = headY - f.getY();
	        double distance = Math.sqrt(dx * dx + dy * dy);
	        
// checks if the head of the snake overlaps with the food's position
	        if (distance < (SEGMENT_SIZE / 2 + Food.FOOD_SIZE / 2)) {
	            BodySegment last = segments.getLast();
	            segments.add(new BodySegment(last.getX(), last.getY(), SEGMENT_SIZE));
	            return true;
	        }

	        return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	// checks if snake is in bounds and returns false if it is out of bounds (play method stops once snake is out of bounds)
	public boolean isInbounds() {
		BodySegment head = segments.getFirst();
	    double x = head.getX();
	    double y = head.getY();
	    return x >= 0 && x <= 1 && y >= 0 && y <= 1;
	}
}
