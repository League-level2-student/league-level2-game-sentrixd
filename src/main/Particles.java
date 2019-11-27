package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Particles {
	int Explosion = 1;
	
	ArrayList<Character> Objects = new ArrayList<Character>();
	
	int createObject(int x, int y, int sx, int sy, String image, Color color) {
		// Insert a new object
		Objects.add(new Character(x,y,sx,sy,image,color));
		
		// Return it's index
		return Objects.size();
	}
	
	void createParticles(int ParticleType) {
		if (ParticleType == Explosion) {
			int r = new Random().nextInt(10)-3;
			
			// Create new objects
			//for (int i = 0; i > r; i ++) {
			createObject(50,50,50,50,"explosion.png",new Color(255,255,255));
				//System.out.println("Created object");
			//}
		}
	}
	
	void updateParticles(Graphics graphic) {
		for (Character g: Objects) {
			g.draw(graphic);
			System.out.println(g.image);
		}
	}
}
