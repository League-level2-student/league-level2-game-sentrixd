package tic_tac_toe;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

public class Computer {
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
			
			
			checkIfWon();
		} else if (mode == 2) {
			
		} else if (mode == 3) {
			
		}
	}
	
	// Check if won //
	/*
	 * Description
	 * 	
	 * 	Retuns 0 if false returns 1 if player won
	 * 	and returns 2 if computer won
	 */
	
	void checkIfWon() {
		if (plays[0] == 1 && plays[1] == 1 && plays[2] == 1) {
			System.out.println("woop de dang dooo");
		}
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
