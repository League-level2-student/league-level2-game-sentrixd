package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import main.Platformer;

public class GamePanel extends JPanel implements ActionListener {
	Timer frameDraw;
	
	String state;
	String[] states = new String[5];
	
	Font[] fonts = new Font[2];
	
	GamePanel() {
		// Intialize all of the States
		states[0] = "Choose Character";
		states[1] = "Menu";
		states[2] = "Game";
		states[3] = "End Screen";
		states[4] = "Shop";
		
		// Initialize all fonts
		fonts[0] = new Font("Avenir Next", Font.PLAIN, 42); // Header
		fonts[1] = new Font("Avenir Next", Font.PLAIN, 16); // Description 1
		
		// Start the frame draw
		frameDraw = new Timer(1/60,this);
        frameDraw.start();
        
        // Update the null state to Choosing Character
        state = states[0];
	}
	
	void createButton(Graphics graphic, int x, int y, int width, int height, String text, Color Background, Color TextColor) {
		graphic.setColor(Background);
		graphic.fillRect(x, y, width, height);
		graphic.setColor(TextColor);
		graphic.drawString(text, x + (width / 2) - 10, y + (height / 2));
	}
	
	void drawCharacterState(Graphics graphic) {
		// Title text
		graphic.setColor(new Color(220, 220, 220));
		graphic.setFont(fonts[0]);
		graphic.drawString("Character choice!", 50, 50);
		
		// Description
		graphic.setColor(new Color(189, 0, 189));
		graphic.setFont(fonts[1]);
		graphic.drawString("Pick something nice for yourself, the square or the ball?", 55, 85);
		
		// Buttons
		createButton(graphic, 50, 50, 250, 250, "test", new Color(232,23,2), new Color(255, 255, 255));
	}
	
	public void paintComponent(Graphics graphic) {
		// Create the background
		graphic.setColor(new Color(33, 33, 33));
		graphic.fillRect(0, 0, Platformer.WIDTH, Platformer.HEIGHT);
		
		// Update the states
		if (state == states[0]) {
			drawCharacterState(graphic);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
