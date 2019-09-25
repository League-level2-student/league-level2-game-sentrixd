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
	
	GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		collisionBox = new Rectangle(xVal, yVal, widthVal, heightVal);
	}
	
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
	}
}
