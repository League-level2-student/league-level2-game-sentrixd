package main;

import java.awt.Color;
import java.awt.Graphics;

public class mapObjects extends GameObject {
	int x;
	int y;
	int targetX;
	int targetY;
	Color colorValue;
	
	mapObjects(int x, int y, int sizeX, int sizeY,String loadImageName, Color colorValue) {
		super(x,y,sizeX,sizeY,loadImageName,colorValue);
		this.x = x;
		this.y = y;
		this.colorValue = colorValue;

	}
	
	void draw(Graphics g) {
		super.update();
		super.draw(g);
		
		g.setColor(colorValue);
        	g.fillRect(x, y, width, height);
	}
}
