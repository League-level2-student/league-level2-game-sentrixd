package game;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import main.mapObjects;


public class Map {
	ArrayList<MapObjects> mapArray = new ArrayList<MapObjects>();
	
	public boolean MapLoaded 	= false;
	public boolean MapLoading 	= false;
	
	
	void CreateMap() {
		String location = getCurrentDirectory() + "/src/game/assets/Map.txt";
		
		try {
			Scanner sc = new Scanner(new File(location));
			
			while (sc.hasNext()) {
				String value = sc.nextLine();
				
				ReadLine(value);
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void ReadLine(String line) {
		// if the length is smaller than this then return and stop the function
		if (line.length() <= 0) {
			return;
		}
		
		// Subsequence detection
		if (line.subSequence(0, 2).equals("//")) {
			// Comment line
		} else if (line.subSequence(0, 6).equals("create")) {
			String[] inputs = line.split(" ");
			
			for (int i = 0; i < inputs.length; i++) {
				System.out.println(inputs[i]);
			}
			
			if (inputs[1].equals("new")) {
				// Create the varibles for using the CreateObject method
				String name;
				
				int xSize, ySize;
				int x, y;
				
				Color color;
				
				// Initialize the varibles
				name = inputs[3];
					
				// Split the string from the ,
				String[] sizes = inputs[4].split(",");
				xSize = Integer.parseInt(sizes[0] + "");
				ySize = Integer.parseInt(sizes[1] + "");
				
				String[] positions = inputs[5].split(",");
				x = Integer.parseInt(positions[0] + "");
				y = Integer.parseInt(positions[1] + "");
					
				String[] colors = inputs[6].split(",");
				int r = Integer.parseInt(colors[0] + "");
				int g = Integer.parseInt(colors[1] + "");
				int b = Integer.parseInt(colors[2] + "");
				
				color = new Color(r,g,b);
				
				// Create the object
				CreateObject(name, xSize, ySize, x, y, color);
			}
		}
	}
	
	void CreateObject(String name, int xSize, int ySize, int x, int y, Color color) { 
		
	}
	
	void displayMap(Graphics graphic) {
		for (MapObjects g : mapArray) {
			g.draw(graphic);
		}
	}
	
	String getCurrentDirectory() {
		String directory = System.getProperty("user.dir");
		
		return directory;
	}
}
