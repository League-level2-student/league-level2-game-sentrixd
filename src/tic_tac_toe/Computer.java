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
	
	int update(ArrayList<JButton> tacbuttons) {
		int placement = 0;
		
		if (mode == 1) {
			for (int i = 0; i < 100; i++) {
				int randomPlaceIndex = randomPlace();
				
				JButton button = tacbuttons.get(randomPlaceIndex);
				
				int place = 0;
				
				if (button.getText().equals("x") || button.getText().equals("o")) {
					place = 1;
				}
				
				if (place == 0) {
					placement = randomPlaceIndex;
				}
			}
		} else if (mode == 2) {
			
		} else if (mode == 3) {
			
		}
		
		return placement;
	}
	
	// Check if won //
	/*
	 * Description
	 * 	
	 * 	Retuns 0 if false returns 1 if player won
	 * 	and returns 2 if computer won
	 */
	
	int checkIfWon(ArrayList<JButton> tacbuttons) {
		
		for (int i = 0; i < 9; i++) {
			System.out.println(tacbuttons.get(i).getText());
		}
		
		return 0;
	}
	
	// Random Place: //
	/*
	 * Description:
	 * 
	 * 		Returns a random number from
	 * 	0-8 which can be used to randomly 
	 * 	place down a (x or a o) for easy
	 * 	mode
	 */
	int randomPlace() {
		int givenPlace = new Random().nextInt(9);
		
		return givenPlace;
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
