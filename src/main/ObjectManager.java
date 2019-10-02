package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ObjectManager {
	Character character;
	
	ObjectManager(Character character) {
		this.character = character;
	}
	
	void generateBalls(int areab) {
		
	}
	
	void update() {
		
	}
	
	void draw(Graphics g) {
		this.character.draw(g);
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
