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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class GameMain extends JLayeredPane implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] states = new String[4];
	Font[] fonts = new Font[2];

	String state;

	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;

	JFrame frame;
	
	String playerName;

	JButton[] tacbuttons = new JButton[9];
	String[] memes = new String[5];

	JButton playButton;
	JButton hiButton;

	JButton easyButton;
	JButton hardButton;

	JLabel instructions;

	Computer computer;

	GameMain(JFrame frame) {
		states[0] = "Menu"; 
		states[1] = "ChooseState";
		states[2] = "Game";
		states[3] = "EndGame";
		
		memes[0] = "https://i.imgflip.com/3phog8.jpg";
		memes[1] = "https://i.imgflip.com/3ow3hu.jpg";
		memes[2] = "https://i.imgflip.com/3q28xl.jpg";
		memes[3] = "https://i.imgflip.com/3q235k.gif";
		memes[4] = "https://i.imgflip.com/3q2dll.jpg";
		
		fonts[0] = new Font("Avenir Next", Font.PLAIN, 42);
		fonts[1] = new Font("Avenir Next", Font.PLAIN, 22);

		computer = new Computer();

		state = states[0];

		CreateBackground();
		
		this.frame = frame;
	}

	void CreateBackground() {
		JLabel background = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource("Background.jpg"));

		setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

		background.setIcon(icon);
		background.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

		// Check the state //

		if (state.equals(states[0])) {
			// Buttons //
			playButton = new JButton("Play");
			hiButton = new JButton("hi wack yo toe");
			instructions = new JLabel(
					"<html>Click play to start the game. It will show a window with the <br> option to choose your mode. Select the mode then the game <br> will load. Click on the squares to place you character (x) and <br> get 3 in a row in any direction to win.</html>");

			instructions.setForeground(Color.white);

			playButton.setBounds(25, 150, 350, 50);
			hiButton.setBounds(25, 210, 350, 50);
			instructions.setBounds(25, 400, 400, 200);

			this.add(background, 0);
			this.add(playButton, 1);
			this.add(hiButton, 1);
			this.add(instructions, 2);

			moveToFront(playButton);
			moveToFront(hiButton);
			moveToFront(instructions);

			playButton.addMouseListener(this);
			hiButton.addMouseListener(this);
		} else if (state.equals(states[1])) {
			// Buttons //
			easyButton = new JButton("uwu mode (wholesome mode)");
			hardButton = new JButton("u can't win xd");

			easyButton.setBounds(25, 150, 350, 50);
			hardButton.setBounds(25, 210, 350, 50);

			this.add(background, 0);
			this.add(easyButton, 1);
			this.add(hardButton, 1); 

			moveToFront(easyButton);
			moveToFront(hardButton);

			easyButton.addMouseListener(this);
			hardButton.addMouseListener(this);
		} else if (state.equals(states[2])) {

			
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
			JOptionPane.showMessageDialog(null, "Your toe is wacked");
			JOptionPane.showMessageDialog(null, "Here are some memes");

			Desktop d = Desktop.getDesktop();
			
			int randomImageNumber = new Random().nextInt(memes.length);

			try {
				
				
				d.browse(new URI(memes[randomImageNumber]));
				//https://i.imgflip.com/3phog8.jpg
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getSource().equals(easyButton)) {
			computer.setMode("regular");

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

			if (e.getSource()==g) {

				// check if this place haven't already been taken
				if (!computer.checkPlace(i)) {
					g.setText("X");

					// change the turn to the computer

					computer.update(i, Computer.PLAYER);
					
					// random
					int[] plays = computer.getTable();

					while (!computer.isFull()) {
						int randInt = new Random().nextInt(9);

						if (plays[randInt] == 0) {
							tacbuttons[randInt].setText("O");

							computer.update(randInt, Computer.COMPUTER);

							break;
						}
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
