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
	
	void Update(ArrayList<Integer> taclist, int side) {
		if (mode == 1) {
			UpdateEasy(taclist, side);
		} else if (mode == 2) {
			
		} else if (mode == 3) {
			
		}
	}
	
	void UpdateEasy(ArrayList<Integer> taclist, int side) {
		while (true) {
			int randomPlace = RandomPlace();
			
			int place = taclist.get(randomPlace);
			
			if (place <= 0) {
				taclist.set(randomPlace, side);
					
				break;
			}
		}
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
	int RandomPlace() {
		int givenPlace = new Random().nextInt(9);
		
		return givenPlace;
	}
	
	void SetMode(int mode) {
		this.mode = mode;
	}
}
