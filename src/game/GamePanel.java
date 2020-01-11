/*
 * Some quick things to remember:
 * In the mouse table:
 * 	mouse[0] returns x
 * 	mouse[1] returns y
 * 
 * States:
 * states[0] default character choosing
 * states[1] Menu
 * states[2] Game
 * states[3] End Screen
 * states[4] Shop
 */


package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import main.Platformer;
import main.mapObjects;

public class GamePanel extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	Character player;
	
	Timer frameDraw;
	
	String state;
	String[] states = new String[5];
	Font[] fonts = new Font[3];
	int[] mouse = new int[2];
	boolean[] debounce = new boolean[1];
	
	ArrayList<Button> buttons = new ArrayList<Button>(0);
	
	// Data
	int score = 0;
	
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
		fonts[2] = new Font("Avenir Next", Font.PLAIN,64); // score
		
		// Start the frame draw
		frameDraw = new Timer(1000/60,this);
        frameDraw.start();
        
        // Update the null state to Choosing Character
        state = states[0];
        
        // Create the character
        player = new Character((Platformer.WIDTH / 2) - 20, (Platformer.HEIGHT / 2) - 20);
        
        // Map testing
        Map mappy = new Map();
        
        mappy.CreateMap();
        
        // Add all listeners
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
	}
	
	void createButton(Graphics graphic, int x, int y, int width, int height, String text, Color Background, Color TextColor, String methodName, String type) {
		graphic.setColor(Background);
		
		if (methodName == "chooseBall") {
			graphic.fillOval(x, y, width, height);
		} else if (type.equals("rounded")) {
			graphic.fillRoundRect(x, y, width, height, 12, 12);
		} else {
			graphic.fillRect(x, y, width, height);
		}
		graphic.setColor(TextColor);
		
		// Get the string size
		int stringwidth = graphic.getFontMetrics().stringWidth(text);
		
		graphic.drawString(text, x + (width / 2) - (stringwidth / 2), y + (height / 2));
		
		int sizex = x + width;
		int sizey = y + height;
		
		Button button = new Button(x ,y, sizex, sizey, methodName);
		
		// Add it to the current array list
		buttons.add(button);
	}
	
	void updateScore(Graphics graphic, Rectangle rect) {
		String text = "Score : " + score;
		
		graphic.setColor(new Color(255, 255, 255));
		graphic.setFont(fonts[2]);
		
		// Get font metrics and as getting the set font
		FontMetrics metrics = graphic.getFontMetrics(graphic.getFont());
		
		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    
	    // draw string
	    graphic.drawString(text, x, y);
	}
	
	void drawCharacterState(Graphics graphic) {
		// Title text
		graphic.setColor(new Color(220, 220, 220));
		graphic.setFont(fonts[0]);
		graphic.drawString("Character choice!", 50, 50);
		
		// Description
		graphic.setColor(new Color(189, 0, 189));
		graphic.setFont(fonts[1]);
		graphic.drawString("Pick something nice for yourself, the square or the ball.", 55, 85);
		
		// Buttons
		createButton(graphic, 50, 100, 175, 175, "Square", new Color(232,23,2), new Color(255, 255, 255), "chooseSquare", "");
		createButton(graphic, 450, 100, 175, 175, "Ball", new Color(232,23,2), new Color(255, 255, 255), "chooseBall", "");
	}
	
	void drawMenuState(Graphics graphic) {
		graphic.setColor(new Color(220, 220, 220));
		graphic.setFont(fonts[0]);
		graphic.drawString("Menu", 15, 50);
		
		// Buttons
		createButton(graphic,(Platformer.WIDTH / 2) - 200, 75, 400, 50, "Play", new Color(255, 255, 255), new Color(0,0,0), "PlayGame", "rounded");
	}
	
	void drawGameState(Graphics graphic) {
		updateScore(graphic, new Rectangle(200,25,275,65));
		
		if (mouse[0] != 0 && mouse[1] != 0) {
			graphic.drawLine(Platformer.WIDTH / 2,Platformer.HEIGHT / 2, mouse[0], mouse[1]);
		}
		
		player.draw(graphic);
	}
	
	void DrawEndScreen(Graphics g) {
		g.drawString("Score: " + score,5,5); 
		g.drawString("~ Stats ~",10,10);
		g.drawString("Total Kills: ",20,20);
		g.drawString("Regular kills: ",30,30);
		g.drawString("Spikes killed: ",40,40);
		g.drawString("Health picked up: ",50,50);
		g.drawString("Total time alive: ",60,60);
	}
	
	public void paintComponent(Graphics graphic) {
		// Create the background
		graphic.setColor(new Color(33, 33, 33));
		graphic.fillRect(0, 0, Platformer.WIDTH, Platformer.HEIGHT);
		
		// Update the states
		if (state == states[0]) {
			drawCharacterState(graphic);
		} else if (state == states[1]) {
			drawMenuState(graphic);
		} else if (state == states[2]) {
			drawGameState(graphic);
		} else if (state == states[3]) {
			DrawEndScreen(graphic);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// Update the mouse position values
		mouse[0] = e.getX();
		mouse[1] = e.getY();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {		
		if (debounce[0] == true) {
			return;
		}
		
		debounce[0] = true;
		
		for (Button b: buttons) {
			
			// Check if the mouse goes within the constraints
			if (mouse[0] > b.x && mouse[0] < b.x + b.sizex && mouse[1] > b.y && mouse[1] < b.y + b.sizey) {
				// Get the method states and return the needed values
				if (b.methodName == "chooseSquare") {
					state = states[1];
				} else if (b.methodName == "chooseBall") {
					state = states[1];
				} else if (b.methodName == "PlayGame") {
					state = states[2];
				} else {
					System.out.println("Unknown method");
				}
			}
		}
		
		debounce[0] = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
}
