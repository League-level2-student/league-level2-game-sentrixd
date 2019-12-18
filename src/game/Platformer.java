package game;

import javax.swing.JFrame;

public class Platformer {

	JFrame frame;
	
	GamePanel gamePanelInstance;
	
	public static final int WIDTH = 750;
	public static final int HEIGHT = 400;
	
	Platformer() {
		frame = new JFrame();
		gamePanelInstance = new GamePanel();
		
		setup();
	}
	
	public static void main(String[] args) {
		Platformer platformerInstance = new Platformer();
	}
	
	void setup() {
		// GamePanel Setup
		frame.add(gamePanelInstance);
		
		// Frame setup
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setTitle("The boomer game");
		
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//int x = (int) screenSize.getHeight();
		//int y = (int) screenSize.getWidth();
		
		frame.setVisible(true);
	}

}
