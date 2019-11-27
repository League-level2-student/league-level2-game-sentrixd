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
	Boolean[][] loadedChuncks = new Boolean[50][50];

	GamePanel panel;
	Character chr;

	int chance = 0;

	BallsAI(GamePanel p) {
		panel = p;
		chr = panel.localPlayer;
	}

	void createBall(int x, int y, String type) {
		balls.add(new Ball(x, y, type));
	}

	int getDistance(int x1, int x2, int y1, int y2) {
		return (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	void generateBalls() {
		int n = new Random().nextInt(15) + 5;

		for (int i = 0; i < n; i++) {
			int c = chunckSize / 2;
			int x = new Random().nextInt(251);
			int y = new Random().nextInt(251);
			int chunck = chunckSize / 2 + 1;

			//System.out.println(chance);
			if (chance >= 100) {
				int ballType = new Random().nextInt(3);

				if (ballType == 1) {
					//createBall(x, y, "Health");
				} else if (ballType == 2) {
					//createBall(x, y, "evilspikey2");
				} else if (ballType == 3) {
					System.out.println("yeet");
				}

				chance = 0;
			} else {
				chance += specialSpawnRate;
				if (getDistance(c, c, x, y) < chunckSize / 2) {
					x += chr.x - c;
					y += chr.y - c;

					//createBall(x, y, "friendly");
				}
			}
		}
	}

	void displayBalls(Graphics graphic) {
		for (Ball g : balls) {
			g.draw(graphic);
		}
	}
}
