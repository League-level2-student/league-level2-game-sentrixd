package tic_tac_toe;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
	/*
	 * mode 1 = easy;
	 * mode 2 = intermediate;
	 * mode 3 - semi-impossible;
	 */
	
	int mode = 0;
	
	void update(ArrayList<Integer> taclist, int side) {
		if (mode == 1) {
			updateEasy(taclist, side);
		} else if (mode == 2) {
			
		} else if (mode == 3) {
			
		}
	}
	
	void updateEasy(ArrayList<Integer> taclist, int side) {
		while (true) {
			int randomPlaceIndex = randomPlace();
			
			int place = taclist.get(randomPlaceIndex);
			
			if (place <= 0) {
				taclist.set(randomPlaceIndex, side);
					
				break;
			}
		}
	}
	
	void checkIfWon() {
		
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
	
	void setMode(int mode) {
		this.mode = mode;
	}
	
	int getMode() {
		return this.mode;
	}
}
