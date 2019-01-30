
public class Blackjack {

	public int play(int i, int j) {
			
		if((i<2 || i>31) || (j<2 || j>31)) {
			return -1;
		}
		if(i > 21 && j > 21) {
			return 0;
		}else if(j >21) {
			return i;
		}else if(i >21) {
			return j;
		}
		if((i<22 && j<22)) {
			if(i > j) {
				return i;
			}else if(i<j) {
				return j;
			}
		}
		return 0;
		
		/*int userInput = 0;
		
		
		switch(userInput) {
		case 1: if((i<2 || i>31) || (j<2 || j>31)) {
			return -1;
		}
		case 2: if(i > 21 && j > 21) {
			return 0;
		}
		case 3: if(j>21) {
			return i;
		}
		case 4: if(i>21) {
			return j;
		}
		case 5: if((i<22 && j<22)) {
			if(i > j) {
				return i;
			}else if(i<j) {
				return j;
			}
		}
		
		}
		
		return 0;
		*/
		
	}

}
