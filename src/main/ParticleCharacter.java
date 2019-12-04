package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class ParticleCharacter extends GameObject {
	public boolean needImage = true;
	public boolean gotImage = false;
	
	// Buffered Images
	public BufferedImage[] images = new BufferedImage[5];
	
	
	int x, y, targetX, targetY;
	int imageIndex;
	
	ParticleCharacter(int x, int y, int sizeX, int sizeY,String loadImageName,Color colorValue) {
		super(x,y,sizeX,sizeY,loadImageName,colorValue);
		this.x = x;
		this.y = y;
		
		if (needImage) {
			for (int i = 0; i < images.length; i++) {
				images[i] = loadImage("Explosion" + i + ".png");
			}
		}
		
		// Update image index
		imageIndex = new Random().nextInt(5);
		
		System.out.println("test");
	}
	
	void draw(Graphics graphic) {
		super.update();
		super.draw(graphic);
		
        if (gotImage) {
        	graphic.drawImage(images[imageIndex], x, y, width, height, null);
        } else {
        	graphic.drawOval(305, 180, width, height);
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
	    
	    return null;
	}
}
