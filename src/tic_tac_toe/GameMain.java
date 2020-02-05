package tic_tac_toe;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GameMain extends JLayeredPane implements MouseListener {
	int[] states 	= new int[4];
	Font[] fonts 	= new Font[2];

	int state;
	int turn;
	
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	
	String playerName;
	
	JButton[] tacbuttons = new JButton[9];
	
	JButton playButton;
	JButton hiButton;
	
	JButton easyButton;
	JButton hardButton;
	
	Computer computer;
	
	GameMain() {
		states[0] = 1; // Menu
		states[1] = 2; // Choose state
		states[2] = 3; // Game
		states[3] = 4; // End game (Thanos reference)
		
		
		fonts[0] = new Font("Avenir Next", Font.PLAIN, 42);
		fonts[1] = new Font("Avenir Next", Font.PLAIN, 22);
		
		computer = new Computer();
		
		state = states[0];
		turn = 0; // Player's turn
		
		CreateBackground();
	}
	
	void CreateBackground() {
		JLabel background = new JLabel();
		ImageIcon icon = new ImageIcon(getCurrentDirectory() + "/src/tic_tac_toe/Background.jpg");
		
		setPreferredSize(new Dimension(icon.getIconWidth(),icon.getIconHeight()));
		
		background.setIcon(icon);
		background.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		
		// Check the state //
		
		if (state == states[0]) {
			// Buttons //
			playButton 	= new JButton("Play");
			hiButton	= new JButton("hi wack yo toe");
		
			playButton.setBounds(25,150,350,50);
			hiButton.setBounds(25,210,350,50);
		
		
			this.add(background, 0);
			this.add(playButton, 1);	
			this.add(hiButton, 1);
		
			moveToFront(playButton);
			moveToFront(hiButton);
		
			playButton.addMouseListener(this);
			hiButton.addMouseListener(this);
		} else if (state == states[1]) {
			// Buttons //
			easyButton 	= new JButton("uwu mode (wholesome mode)");
			hardButton	= new JButton("u can't win xd");
					
			easyButton.setBounds(25,150,350,50);
			hardButton.setBounds(25,210,350,50);
					
					
			this.add(background, 0);
			this.add(easyButton, 1);	
			this.add(hardButton, 1);
					
			moveToFront(easyButton);
			moveToFront(hardButton);
			
			easyButton.addMouseListener(this);
			hardButton.addMouseListener(this);
		} else if (state == states[2]) {
			// Insert the background afterwards
			this.add(background, 0);
			
			int x = 0;
			int y = 90;
			
			// Button //
			for (int i = 0; i < 9; i++) {
				System.out.println("YEET");
				tacbuttons[i] = new JButton();
				// Add the clicked Button variable
				JButton clickedButton = tacbuttons[i];
				
				int xBound = 0;
				int width = Startup.WIDTH / 3;
				
				xBound = x * width;
				
				if (x >= 3) {
					x = 0;
					y += 55;
				} else {
					x++;
				}
				
				clickedButton.setBounds(xBound + 40, y, 50, 50);
					
				this.add(clickedButton, i);
				moveToFront(clickedButton);
				
				// Add button
				clickedButton.addMouseListener(this);
			}
		}
	}
	
	void loadGame() {
		if (state == states[2]) {
			// Clear the ArrayList
			tacbuttons = new JButton[9];
			
			// Load the background
			CreateBackground();
		}
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
	
	String getCurrentDirectory() {
		String directory = System.getProperty("user.dir");
		
		return directory;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(playButton)) {
			// Play Button Method //
			
			state = states[1]; // Set the state to the choosing state
			
			// Redraw //
			CreateBackground();
		} else if (e.getSource().equals(hiButton)) {
			// Meme Button Method //
		} else if (e.getSource().equals(easyButton)) {
			// uwu mode uwu //
			computer.setMode(1);
			
			state = states[2];
			
			loadGame();
		}
		
		
		// check if one of those x or o 
		
		for (int i = 0; i < tacbuttons.length; i++) {
			JButton g = tacbuttons[i];
			
			if (e.getSource().equals(g)) {
				
				// if (turn == player) //
				if (turn == 0) {
					g.setText("x");
					
					// change the turn to the computer
					turn = 1;
					
					computer.update(i, 1);
					
					turn = 0;
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
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
