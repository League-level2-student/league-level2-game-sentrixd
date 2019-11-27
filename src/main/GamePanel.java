package main;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

//fakePlayer FIX

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    final int INSTRUCTIONS = 3;
    final int ENDSCREEN = 4;
    final int SHOP = 5;
    final int SETTINGS = 6;
    
    Character localPlayer;
    Character fakePlayer;
    ArrayList<Character> characters;
    ObjectManager objectManager;
    Particles particles;
    Map gameMap;
    BallsAI ballMain;
    Camera cam;
    
    Timer frameDraw;
    Timer countdown;
    
    Font titleFont = new Font("Avenir Next", Font.BOLD, 42);
    Font titleFont1 = new Font("Avenir Next", Font.PLAIN, 42);
    Font lowerFont1 = new Font("Avenir Next", Font.PLAIN, 16);
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
        particles = new Particles();
        
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
		} else if (currentState == INSTRUCTIONS) {
			drawInstructionState(g);
		} else if (currentState == SHOP) {
			drawShop(g);
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
		
		g.setColor(Color.WHITE);
		
		// 200 150 to 325 275
		
		g.fillRect(200, 150, 125, 125);
		g.setColor(Color.BLACK);
		g.drawString("Play", 250, 225);
		// 375 150 to 500 275
		g.setColor(Color.ORANGE);
		g.fillRect(375, 150, 125, 125);
		g.setColor(Color.white);
		g.drawString("Shop", 425, 225);
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
   		particles.updateParticles(g);
    }
    
    void drawInstructionState(Graphics g) {
    	// Font
    	g.setFont(titleFont1);
    	g.setColor(Color.RED);
    	g.drawString("Instructions:", 50, 50);
    	g.setFont(lowerFont1);
    	g.setColor(Color.MAGENTA);
    	g.drawString("    Use the mouse to move around! By clicking, the ball or square which ever you choose will", 50, 100);
    	g.drawString("head to.", 50, 125);
    	g.setColor(Color.CYAN);
    	g.drawString("    Try avoiding the red spikes! They will attack you and if you get too close then it will blow", 50, 175);
    	g.drawString("up and you will die! The balls that look like '+' icons give you health! Regular balls (blue ones)", 50, 200);
    	g.drawString("give you score points which you can trade in for upgrades such as power-ups, new character", 50, 225);
    	g.drawString("designs and particles!", 50, 250);
    	g.setColor(Color.RED);
    	g.drawString("Press [B] to return to the menu", 500, 35);
    }
    
    void drawShop(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.fillRect(50, 50, 20, 350);
    }

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (currentState == MENU) {
				currentState = GAME;
				countdown.start();
				gameMap.loadMap();
				ballMain.generateBalls();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_I) {
			currentState = INSTRUCTIONS;
		} else if (e.getKeyCode() == KeyEvent.VK_B) {
			if (currentState == INSTRUCTIONS) {
				currentState = MENU;
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
		x = e.getX();
		y = e.getY();
		
		int q,z;
		
		q = e.getX(); z = e.getY();
		
		// 200 150 to 325 275
		// 375 150 to 500 275
		// Button connections
		if (currentState == MENU) {
			if (q > 200 && z > 150) {
				if (q < 325 && z < 275) {
					currentState = GAME;
					countdown.start();
					gameMap.loadMap();
					ballMain.generateBalls();
				}
			} 
			if (q > 375 && z > 150) {
				if (q < 500 && z < 275) {
					currentState = SHOP;
				}
			}
		}
		
		ballMain.generateBalls();
		particles.createParticles(1);
		
		
		//void createParticles(GameObject g, int ParticleType) {
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
