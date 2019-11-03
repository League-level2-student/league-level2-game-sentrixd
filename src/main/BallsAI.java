package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/*
 * P.S.: 
 * The types of balls are
 * Regular
 * Explosion
 * Health
 * Spikes
 */

public class BallsAI {
	final static int specialSpawnRate = 5; // 5 Percent chance that a special ball will spawn
	final static int ballsPerChunck = 15; // How many balls to generate per chunck size
	final static int chunckSize = 250; // X = Y and Y = X in pixels
	
	ArrayList<Ball> balls = new ArrayList<Ball>(); 
	
	GamePanel panel;
	Character chr;
	
	int chance = 0;
	
	
	BallsAI(GamePanel p) {
		panel = p;
		chr = panel.localPlayer;
	}
	
	void createBall(int x,int y,String type) {
		balls.add(new Ball(x,y,type));
	}
	
	int getDistance(int x1,int x2,int y1,int y2) {
		return (int) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	
	void generateBalls() {
		if (chance >= 100) {
			int ballType = new Random().nextInt(3);
			
			if (ballType == 1) {
				createBall(3,3,"Health");
			}
			
			chance = 0;
		} else {
			chance += specialSpawnRate;
			
			int c = chunckSize/2;
			int x = new Random().nextInt(251);
			int y = new Random().nextInt(251);
			int chunck = chunckSize / 2 + 1;
			
			if (getDistance(c,c,x,y) < chunckSize/2) {
				x += chr.x - c;
				y += chr.y - c;
				
				createBall(x,y,"Health");
			}
		}
	}
	
	void displayBalls(Graphics graphic) {
		for (Ball g: balls) {
			g.draw(graphic);
		}
	}
}
