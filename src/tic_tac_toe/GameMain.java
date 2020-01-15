package tic_tac_toe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.Platformer;

public class GameMain extends JPanel implements ActionListener {
	Timer frameDraw;
	
	int[] states = new int[3];
	Font[] fonts = new Font[2];
 	
	int state;
	
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	
	
	JButton PlayButton;
	
	GameMain() {
		states[0] = 1; // Menu
		states[1] = 2; // Game
		states[2] = 3; // End game (thanos reference)
		
		fonts[0] = new Font("Avenir Next", Font.PLAIN, 42);
		fonts[1] = new Font("Avenir Next", Font.PLAIN, 22);
		
		state = states[0];
		
		frameDraw = new Timer(1000/60, this);
        frameDraw.start();
	}
	
	void DrawMenu(Graphics g) {
		g.setFont(fonts[1]);
		g.setColor(new Color(255, 255, 255));
		g.drawString("Tic-Tac-Toe!", 130, 20);
		
		if (PlayButton == null) {
			System.out.println("Yeet");
			PlayButton = new JButton();
			
			PlayButton.setText("Play!");
			
			this.add(PlayButton);
		} 
		
	}
	
	void CreateBackground(Graphics g) {
		if (image == null) {
			System.out.println("existo mate");
			loadImage("Background.jpg");
		}
		
		g.drawImage(image, 0, 0, 400, 750, null);
		if (PlayButton == null) {
			System.out.println("Yeet");
			PlayButton = new JButton();
			
			PlayButton.setText("Play!");
	
		}
			
		this.add(PlayButton);
	}
	
	public void paintComponent(Graphics g) {
		// Load the background every frame
		CreateBackground(g);
		
		if (state == states[0]) {
			DrawMenu(g);
		}
	}
	
	// Frame draw
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
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
