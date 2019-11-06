package main;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JPanel;

//fakePlayer FIX

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    
    Character localPlayer;
    Character fakePlayer;
    ArrayList<Character> characters;
    ObjectManager objectManager;
    Map gameMap;
    BallsAI ballMain;
    Camera cam;
    
    Timer frameDraw;
    Timer countdown;
    
    Font titleFont = new Font("Avenir Next", Font.BOLD, 42);;
    Font lowerFont1 = new Font("Avenir Next", Font.PLAIN, 16);;
    Font countdownFont = new Font("Avenir Next", Font.PLAIN, 32);
    
    int currentState = MENU;	
    int currentNumber = 3;
    
    int currentPoints = 0;
    int totalPoints = 0;
    
    int gamespeed = 1;
    
    int x,y,xVal,yVal;
    
    GamePanel() {
   		countdown = new Timer(1000,this);
        frameDraw = new Timer(1/60,this);
        frameDraw.start();
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
        characters = new ArrayList<Character>();
        objectManager = new ObjectManager(characters);
        
        localPlayer = new Character(305, 180, 30,30,"character.png",null);
        fakePlayer = new Character(305,180,30,30,"fakeCharacter.png",null);
        characters.add(localPlayer);
        characters.add(fakePlayer);
        
        gameMap = new Map();
        
        ballMain = new BallsAI(this);
        cam = new Camera(this,gameMap);
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
    		cam.update();
    		gameMap.displayMap(g);
    		ballMain.displayBalls(g);
    }

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
				currentState = GAME;
				countdown.start();
				gameMap.loadMap();
				ballMain.generateBalls();
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
		 
		 if (localPlayer != null && currentState == GAME) {
			 //localPlayer.y += 0.1; fixo
		 }
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		x = e.getX() + x;
		y = e.getY() + y;
		ballMain.generateBalls();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		 xVal = e.getPoint().x;
		 yVal = e.getPoint().y;
	}

	public void mousePressed(MouseEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}
