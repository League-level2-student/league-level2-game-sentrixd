package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Map {
	ArrayList<mapObjects> mapArray = new ArrayList<mapObjects>();

	void addObject(int x, int y, int x1, int y1, Color c) {
		mapArray.add(new mapObjects(x, y, x1, y1, null, c));
	}

	void loadMap() {
		// x,y position x,y size
		addObject(-1250, 350, 5000, 100, new Color(235, 85, 52));
		addObject(250, 330, 300, 20, new Color(255, 255, 255));
	}

	void displayMap(Graphics graphic) {
		for (mapObjects g : mapArray) {
			g.draw(graphic);
		}
	}

	void adjustMap(int x, int y) {
		for (mapObjects g : mapArray) {
			g.x = g.x-(x-(Platformer.WIDTH/2));
			g.y = g.y-(y-(Platformer.HEIGHT/2));
		}
	}
}
