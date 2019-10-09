package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ObjectManager {
	 ArrayList<Character> characters;
	
	ObjectManager(ArrayList<Character> character) {
		this.characters = character;
	}
	
	void generateBalls(int areab) {
		
	}
	
	void update() {
		
	}
	
	void draw(Graphics g) {
		for (Character c: characters) {
			c.draw(g);
		}
	}
	
	void purgeObjects() {
		
	}
	
	void checkCollision() {
		//for (int i = 0; i < aliens.size(); i++) {
			//if (roket.collisionBox.intersects(aliens.get(i).collisionBox)) {
				//aliens.get(i).isActive = false;
				//roket.isActive = false;
			//}
		//}
	}
}
