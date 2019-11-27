package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ParticleCharacter extends GameObject {
	public boolean needImage = true;
	public boolean gotImage = false;
	
	// Buffered Images
	public BufferedImage[] images = new BufferedImage[5];
	
	
	int x;
	int y;
	int targetX;
	int targetY;
	
	ParticleCharacter(int x, int y, int sizeX, int sizeY,String loadImageName,Color colorValue) {
		super(x,y,sizeX,sizeY,loadImageName,colorValue);
		this.x = x;
		this.y = y;
		
		if (needImage) {	
			for (int i = 0; i < images.length; i++) {
				images[i] = loadImage("Explosion" + i + ".png");
			}
		}
	}
	
	void draw(Graphics g) {
		super.update();
		super.draw(g);
		
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.drawOval(305, 180, width, height);
        }
	}
	
	BufferedImage loadImage(String imageFile) {
	    if (needImage) {
	        try {
	        	gotImage = true;
	            return ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	        } catch (Exception e) {
	            System.out.println("Error failed to load image file. Name:" + imageFile +  "Reason:" + e);
	            needImage = false;
		        return null;
	        }
	    }
	}
}
