package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	 int x;
	 int y;
	 int width;
	 int height;
	 int speed;
	 String imageName;
	 boolean isActive;
	 Rectangle collisionBox;
	
	GameObject(int x, int y, int sizeX, int sizeY,String loadImageName, Color ColorThing) {
		this.x = x;
		this.y = y;
		this.width = sizeX;
		this.height = sizeY;
		
		if (loadImageName != null) {
			imageName = loadImageName;
		}
		collisionBox = new Rectangle(x, y, sizeX, sizeY);
	}
	
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	
	void draw(Graphics g) {
		//g.setColor(Color.GREEN);
		//g.drawOval(20, 20, width, height);
	}
}
