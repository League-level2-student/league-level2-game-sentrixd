package tic_tac_toe;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GameMain extends JLayeredPane implements MouseListener {
	int[] states 	= new int[4];
	Font[] fonts 	= new Font[2];

 	
	int state;
	
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	
	String playerName;
	
	ArrayList<Integer> taclist = new ArrayList<Integer>();
	ArrayList<JButton> tacbuttons = new ArrayList<JButton>();
	
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
		
		CreateBackground();
		
		// ArrayList //
		for (int i = 0; i < 9; i++) {
			taclist.add(i, 0);
		}
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
			// Button // 
			for (int i = 0; i < 9; i++) {
				JButton clickedButton = new JButton("uwu");
				
				tacbuttons.add(clickedButton);
				
				clickedButton.setBounds(i + 10 + 20,50,50,50);
				
				this.add(background, 0);
				this.add(clickedButton, i);
				
				moveToFront(clickedButton);
			}
		}
	}
	
	void loadGame() {
		if (state == states[2]) {
			// Clear the ArrayList
			tacbuttons.removeAll(tacbuttons);
			
			// Load the background
			CreateBackground();
			
			System.out.println("ok");
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
			
			System.out.println("Loading game JPanel ...");
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
