package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Character extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	
	int x;
	int y;
	int targetX;
	int targetY;
	
	Character(int x, int y, int sizeX, int sizeY,String loadImageName,Color colorValue) {
		super(x,y,sizeX,sizeY,loadImageName,colorValue);
		this.x = x;
		this.y = y;
		if (needImage) {
		    loadImage (loadImageName);
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
