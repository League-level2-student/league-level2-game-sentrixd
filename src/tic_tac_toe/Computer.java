package tic_tac_toe;

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
	
	boolean checkPlace(int place) {
		if (plays[place] == 1 || plays[place] == 2) {
			return true;
		} else {
			return false;
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
		
		boolean isNull = false;
		
		// Check if all the spots are filled
		for (int i = 0; i < plays.length; i++) {
			if (plays[i] == 0) {
				isNull = true;
				break;
			}
		}
		// Following to the top line
		if (isNull == false) {
			JOptionPane.showMessageDialog(null, "tie better than loosing i guess.'");
			
			restart();
		}
	}
	
	void restart() {
		Startup.frame.setVisible(false);
		
		new Startup();
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
