package tic_tac_toe;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class GameMain extends JLayeredPane implements MouseListener {
	int[] states 	= new int[4];
	Font[] fonts 	= new Font[2];

	int state;
	
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	
	String playerName;
	
	JButton[] tacbuttons = new JButton[9];
	
	JButton playButton;
	JButton hiButton;
	
	JButton easyButton;
	JButton hardButton;
	
	JLabel instructions;
	
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
			instructions= new JLabel ("<html>Basicly you click play, choose the mode and then you<br/>click the buttons then once you do that you need <br/> to get 3 in a row.</html>");
			
			instructions.setForeground(Color.white);
			
			playButton.setBounds(25,150,350,50);
			hiButton.setBounds(25,210,350,50);
			instructions.setBounds(25, 400, 400, 200);
		
		
			this.add(background, 0);
			this.add(playButton, 1);	
			this.add(hiButton, 1);
			this.add(instructions,2);
		
			moveToFront(playButton);
			moveToFront(hiButton);
			moveToFront(instructions);
		
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
				tacbuttons[i] = new JButton();
				// Add the clicked Button variable
				JButton clickedButton = tacbuttons[i];
				
				int xBound = 0;
				int width = Startup.WIDTH / 3;
				
				xBound = x * width;
				
				clickedButton.setBounds(xBound + 40, y, 50, 50);

				this.add(clickedButton, i);
				moveToFront(clickedButton);
				
				if (x >= 2) {
					x = 0;
					y += 55;
				} else {
					x++;
				}
				
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
			JOptionPane.showMessageDialog(null, "ur toe is wacked");
			JOptionPane.showMessageDialog(null, "here sum memes for ur agony");
			
			Desktop d = Desktop.getDesktop();
			
			try {
				d.browse(new URI("https://i.imgflip.com/3ow3hu.jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
		} else if (e.getSource().equals(easyButton)) {
			// uwu mode uwu //
			computer.setMode(1);
			
			// Reset the button mouse listeners
			easyButton.removeMouseListener(this);
			hiButton.removeMouseListener(this);
			
			state = states[2];
			
			loadGame();
		} else if (e.getSource().equals(hardButton)) {
			JOptionPane.showMessageDialog(null, "Computer won ur bad!");
		}
		
		
		// check if one of those x or o 
		
		for (int i = 0; i < tacbuttons.length; i++) {
			JButton g = tacbuttons[i];
			
			if (e.getSource().equals(g)) {
				
				// if (turn == player) //
				g.setText("x");
					
				// change the turn to the computer
					
				computer.update(i, Computer.PLAYER);
					
				// random
				int[] plays = computer.getTable();
					
				while (true) {
					int randInt = new Random().nextInt(8);
						
					if (plays[randInt] == 0) {
						computer.update(randInt, Computer.COMPUTER);
							
						tacbuttons[randInt].setText("o");
							
						break;
					}
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
