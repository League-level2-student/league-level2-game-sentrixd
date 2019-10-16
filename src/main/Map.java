package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Map {
	ArrayList<mapObjects> mapArray = new ArrayList<mapObjects>(); 
	
	void loadMap() {
		// x,y position x,y size
		mapArray.add(new mapObjects(0,290,2000,100,null,new Color(235, 85, 52)));
		mapArray.add(new mapObjects(250,270,300,20,null,new Color(255, 255, 255)));
	}
	
	void displayMap(Graphics graphic) {
		for (mapObjects g: mapArray) {
			g.draw(graphic);
		}
	}
}
