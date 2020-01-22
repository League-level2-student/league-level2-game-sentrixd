package tic_tac_toe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.Platformer;

public class GameMain extends JLayeredPane {
	int[] states = new int[3];
	Font[] fonts = new Font[2];
 	
	int state;
	
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	
	String playerName;
	
	ArrayList<Integer> taclist = new ArrayList<Integer>();
	
	GameMain() {
		states[0] = 1; // Menu
		states[1] = 2; // Game
		states[2] = 3; // End game (thanos reference)
		
		fonts[0] = new Font("Avenir Next", Font.PLAIN, 42);
		fonts[1] = new Font("Avenir Next", Font.PLAIN, 22);
		
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
		// Buttons //
		JButton playButton = new JButton("Play");
		
		playButton.setBounds(50,50,50,50);
		
		this.add(background, 0);
		this.add(playButton, 1);	
		
		moveToFront(playButton);
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
}
