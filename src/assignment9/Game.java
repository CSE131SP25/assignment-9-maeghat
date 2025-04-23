package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {

    private Snake snake;
    private Food food;
    private int score;

	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		 StdDraw.setCanvasSize(600, 600);
	        StdDraw.setXscale(0, 1);  // logical coordinates from 0 to 1
	        StdDraw.setYscale(0, 1);
	        StdDraw.enableDoubleBuffering();

	        snake = new Snake();
	        food = new Food();
	        score = 0; // Start score at 0

	        
	        }
	
	public void play() {
		//checks for keyboard input to change the snake's direction
		//moves the snake, checks if it eats food and respawns food if it does
		// loop continues running as long as the snake is in bounds
		
		 while (snake.isInbounds()) {
	            int dir = getKeypress();
	            if (dir != -1) {
	                snake.changeDirection(dir);
	            }

	            snake.move();

	            if (snake.eatFood(food)) {
	                food = new Food();// respawns food
				    score++;           // increase score

	            }

	            updateDrawing();

	            StdDraw.pause(100); // Adjust for desired speed
	        }
	

	        // Game over screen
	        StdDraw.clear();
	        StdDraw.setPenColor(StdDraw.RED);
	        StdDraw.text(0.5, 0.5, "Game Over! Final Score: " + score);
	        StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
		
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		  StdDraw.clear();
	        food.draw();
	        snake.draw();
	        StdDraw.show();	
	        
	     // Draw score at top 
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(0.5, 0.95, "Score: " + score);

	        StdDraw.show();
	        StdDraw.pause(50);
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
