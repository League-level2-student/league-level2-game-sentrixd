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
	 boolean isActive;
	 Rectangle collisionBox;
	
	GameObject(int x, int y, int sizeX, int sizeY) {
		this.x = x;
		this.y = y;
		this.width = sizeX;
		this.height = sizeY;
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
