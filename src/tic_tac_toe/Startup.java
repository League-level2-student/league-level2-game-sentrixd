package tic_tac_toe;

import javax.swing.JFrame;

public class Startup {
	public static JFrame frame;

	GameMain gamePanelInstance;

	public static final int WIDTH = 400;
	public static final int HEIGHT = 750;

	Startup() {
		frame = new JFrame();
		gamePanelInstance = new GameMain(frame);

		setup();
	}

	public static void main(String[] args) {
		new Startup();
	}

	void setup() {
		// GamePanel Setup
		frame.add(gamePanelInstance);

		// Frame setup
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);

		// Simple customizations
		frame.setTitle("tik tok");
		frame.setLocationRelativeTo(null);

		// Make the frame visible
		frame.setVisible(true);
	}
}