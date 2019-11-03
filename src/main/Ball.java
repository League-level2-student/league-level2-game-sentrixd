package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Ball {
	 int x;
	 int y;
	 int width;
	 int height;
	 int speed;
	 String imageName;
	 boolean isActive;
	 Rectangle collisionBox;
	
	 public static BufferedImage image;
	 public static boolean needImage = true;
	 public static boolean gotImage = false;
	 
	Ball(int x, int y, String type) {
		this.x = x;
		this.y = y;
		this.width = 35;
		this.height = 35;
		
		loadImage(type + ".png");
		
		//if (loadImageName != null) {
		//	this.imageName = loadImageName;
		//}
		collisionBox = new Rectangle(x, y, 20, 20);
	}
	
	void update() {
		collisionBox.setBounds(x, y, width, height);
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
