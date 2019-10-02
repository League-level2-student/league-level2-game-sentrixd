package main;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    
    ObjectManager objectManager;
    Map gameMap;
    
    Timer frameDraw;
    Timer countdown;
    
    Font titleFont = new Font("Avenir Next", Font.BOLD, 42);;
    Font lowerFont1 = new Font("Avenir Next", Font.PLAIN, 16);;
    Font countdownFont = new Font("Avenir Next", Font.PLAIN, 32);
    
    int currentState = MENU;
    int currentNumber = 3;
    
    int currentPoints = 0;
    int totalPoints = 0;
    
    int playerX, player;
    
    GamePanel() {
   		countdown = new Timer(1000,this);
        frameDraw = new Timer(1/60,this);
        
        frameDraw.start();
        
        this.addMouseListener(this);
        
        objectManager = new ObjectManager(new Character(20,20,20,20));
        gameMap = new Map();
        gameMap.loadMap();
    }
    
    public void paintComponent(Graphics g) {
    	// set color
		g.setColor(new Color(33,33,33));
		g.fillRect(0, 0, Platformer.WIDTH, Platformer.HEIGHT);
		
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		}
	}

    void drawMenuState(Graphics g) { 
		// Title
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("Bounce", 300, 50);
		// Bottom Text
		g.setFont(lowerFont1);
		g.setColor(new Color(15,235,3));
		g.drawString("Press space to start", 300, 350);
		
	}
    
    void drawGameState(Graphics g) {
    		// Title
    		g.setFont(titleFont);
    		g.setColor(Color.WHITE);
    		g.drawString("Score: ", 300, 50);
    		// Countdown
    		g.setFont(countdownFont);
    		g.setColor(new Color(15,235,3));
    	
    		if (currentNumber != 15) {
    			g.drawString(currentNumber + "", 300, 150);
    		}
    		objectManager.draw(g);
    }

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
				System.out.println("Game state startesd");
				currentState = GAME;
				countdown.start();
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(frameDraw)) {
			repaint();
		}
			
		if (e.getSource().equals(countdown)) {
			currentNumber--;
			if (currentNumber < 0) {
				currentNumber = 15;
				countdown.stop();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("yee2t");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("yeet");
		int pointX = e.getPoint().x;
		int pointY = e.getPoint().y;
		System.out.println(pointX + " " + pointY);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
