package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Character {
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	
	String ImageLocation = "assets/character.png";
	
	int x;
	int y;
	int width = 40;
	int height = 40;
	
	Character(int x, int y) {
		this.x = x;
		this.y = y;
		
		// Load the current image
		loadImage(ImageLocation);
	}
	
	void draw(Graphics g) {
		if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.drawOval(305, 180, width, height);
        }
	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	            gotImage = true;
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        needImage = false;
	    }
	}
}
