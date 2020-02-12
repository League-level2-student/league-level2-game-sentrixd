package tic_tac_toe;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Computer {
	static final int PLAYER = 1;
	static final int COMPUTER = 2;
	
	/*
	 * mode 1 = easy;
	 * mode 2 = intermediate;
	 * mode 3 - semi-impossible;
	 */
	
	int mode = 0;
	
	int[] plays = new int[9];
	
	void update(int index, int type) {
		if (mode == 1) {
			plays[index] = type;
			checkIfWon(type);
		}
	}
	
	void checkIfWon(int player) {
		if (plays[0] == player && plays[1] == player && plays[2] == player || plays[3] == player && plays[4] == player && plays[5] == player || plays[6] == player && plays[7] == player && plays[8] == player) {
			// Direct from left to right
			System.out.println("Player equals " + player);
			if (player == PLAYER) {
				JOptionPane.showMessageDialog(null, "you won gud job");
			} else if (player == COMPUTER) {
				JOptionPane.showMessageDialog(null, "TRASHHHHSHHSHSHHH KID YOU COULDN'T EVEN BEAT  A COMPUTER THAT RANDOMLY GUESSES TRASSHHSHSHSHHHH");
			}
			restart();
		} else if (plays[0] == player && plays[3] == player && plays[6] == player || plays[1] == player && plays[4] == player && plays[7] == player || plays[2] == player && plays[5] == player && plays[8] == player) {
			// Top to bottom
			if (player == PLAYER) {
				JOptionPane.showMessageDialog(null, "you won gud job");
			} else if (player == COMPUTER) {
				JOptionPane.showMessageDialog(null, "TRASHHHHSHHSHSHHH KID YOU COULDN'T EVEN BEAT  A COMPUTER THAT RANDOMLY GUESSES TRASSHHSHSHSHHHH");
			}
			restart();
		} else if (plays[0] == player && plays[4] == player && plays[8] == player || plays[2] == player && plays[4] == player && plays[6] == player) {
			// Top left to bottom right
			if (player == PLAYER) {
				JOptionPane.showMessageDialog(null, "you won gud job");
			} else if (player == COMPUTER) {
				JOptionPane.showMessageDialog(null, "TRASHHHHSHHSHSHHH KID YOU COULDN'T EVEN BEAT  A COMPUTER THAT RANDOMLY GUESSES TRASSHHSHSHSHHHH");
			}
			restart();
		}
	}
	
	void restart() {
		Startup.frame.setVisible(false);
		
		Startup startupInstance = new Startup();
	}
	
	int[] getTable() {
		return plays;
	}
	
	// Returns the current mode //
	void setMode(int mode) {
		this.mode = mode;
	}
	// Gets the current mode //
	int getMode() {
		return this.mode;
	}
}
