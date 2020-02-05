package tic_tac_toe;

import javax.swing.JFrame;

import game.GamePanel;
import game.Platformer;

public class Startup {
	static JFrame frame;
	
	GameMain gamePanelInstance;
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 750;
	
	Startup() {
		frame = new JFrame();
		gamePanelInstance = new GameMain();
		
		setup();
	}
	
	public static void main(String[] args) {
		Startup startupInstance = new Startup();
	}
	
	void setup() {
		// GamePanel Setup
		frame.add(gamePanelInstance);
		
		// Frame setup
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		
		// Simple customizations
		frame.setTitle("Tic wac yo toe");
		frame.setLocationRelativeTo(null);
		
		// Make the frame visible
		frame.setVisible(true);
		
		System.out.println("Loaded Panel!");
	}
}