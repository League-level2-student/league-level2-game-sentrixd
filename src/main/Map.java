package main;

import java.util.Scanner;

public class Map {
	Scanner mapScan = new Scanner("Map.txt");
	
	void loadMap() {
		System.out.println(mapScan.next().charAt(3));
	}
}
