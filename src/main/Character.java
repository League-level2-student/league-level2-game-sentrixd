package main;

import java.awt.Graphics;

public class Character extends GameObject {
	int x;
	int y;
	int targetX;
	int targetY;
	
	Character(int x, int y) {
		super.update(x,y);
		this.x = x;
		this.y = y;
	}
	
	void draw(Graphics g) {
		
	}
	
	
}
