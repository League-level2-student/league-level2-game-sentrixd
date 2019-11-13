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
	
	public static double[] interpolate(double start, double end, int count) {
	    if (count < 2) {
	        throw new IllegalArgumentException("interpolate: illegal count!");
	    }
	    double[] array = new double[count + 1];
	    for (int i = 0; i <= count; ++ i) {
	        array[i] = start + i * (end - start) / count;
	    }
	    return array;
	}

	void adjustMap(int x, int y) {
		for (mapObjects g : mapArray) {
			System.out.println(g.x + (Platformer.WIDTH / 2) - x);
			System.out.println(g.y - (Platformer.HEIGHT / 2) + y);
			g.x = g.x + (Platformer.WIDTH / 2) - x;
			g.y = g.y + (Platformer.HEIGHT / 2) - y;
		//	g.y = g.y-(y-(Platformer.HEIGHT/2));
		}
	}
}
