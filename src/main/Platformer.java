package main;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Platformer {

	JFrame frame;
	
	GamePanel gamePanelInstance;
	
	public static final int WIDTH = 750;
	public static final int HEIGHT = 400;
	
	Platformer() {
		frame = new JFrame();
		gamePanelInstance = new GamePanel();
		
		frame.addKeyListener(gamePanelInstance);
		setup();
	}
	
	public static void main(String[] args) {
		Platformer platformerInstance = new Platformer();
	}
	
	void setup() {
		// Game Panel Setup
		frame.add(gamePanelInstance);
		
		// Frame setup
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}

}
