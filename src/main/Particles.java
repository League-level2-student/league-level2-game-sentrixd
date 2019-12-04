package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Particles {
	int Explosion = 1;
	
	ArrayList<ParticleCharacter> Objects = new ArrayList<ParticleCharacter>();
	
	int createObject(int x, int y, int sx, int sy, String image, Color color) {
		// Insert a new object
		Objects.add(new ParticleCharacter(x,y,sx,sy,image,color));
		
		// Return it's index
		return Objects.size();
	}
	
	void createParticles(int ParticleType) {
		if (ParticleType == Explosion) {
			int particlesAmount = new Random().nextInt(3) + 3;
			
			System.out.println(particlesAmount);
			
			// Create new objects
			for (int i = 0; i < particlesAmount; i ++) {
				createObject(50,50,50,50,"explosion.png",new Color(255,255,255));
			}
		}
	}
	
	void updateParticles(Graphics graphic) {
		for (ParticleCharacter g: Objects) {
			g.draw(graphic);
		}
	}
}
