package threadValidator;

public class FoundSolution implements Runnable{
	
	private int[][] solution = new int[9][9];
    private int[] check = new int[9];


    private int valid;
    private int valid2;
    
    int invalidNum;
    
    int ones = 0;
	int twos = 0;
	int threes = 0;
	int fours = 0;
	int fives = 0;
	int sixes = 0;
	int sevens = 0;
	int eights = 0;
	int nines = 0;

	
	public FoundSolution(int[][] data){
		
		this.solution = data;
		this.valid = 1;
		this.valid2 = 1;	
		
		int n = 0;
		for (n = 0; n < 9; ++n){
			
			check[n] = 0;
		}

	}
	
	public void run(){
		
		int r = 0;
		int c = 0;
		int r2 = 0;
		int c2 = 0;
		
		int[] currentLine = new int[9];
		int[] currentLine2 = new int[9];
		
		while (c < 9){
			
			for (r = 0; r < 9; ++r){
				currentLine[r] = solution[c][r];
			}
			
			for (r = 0; r < 9; ++r){
				
				switch(currentLine[r]){
					case 1: check[0] = 1;
						break;
					case 2: check[1] = 1;
						break;
					case 3: check[2] = 1;
						break;
					case 4: check[3] = 1;
						break;
					case 5: check[4] = 1;
						break;
					case 6: check[5] = 1;
						break;
					case 7: check[6] = 1;
						break;
					case 8: check[7] = 1;
						break;
					case 9: check[8] = 1;
						break;
					default:valid = 0;
						break;
				}
			}
			
			for (r = 0; r < 9; ++r){
				
				if(check[r] != 1){
					
					valid = 0;
				}
			}
			
			if (valid == 0) {

				invalidNum = c+1;
				
			}
			
			c++;
			valid = 1;
			for (r = 0; r < 9; ++r){
				
				check[r] = 0;
			}
		}
		
		while (c2 < 9) {
			
			for (r2 = 0; r2 < 9; ++r2){
				
				currentLine2[r2] = solution[r2][c2];
			}
			
			for (r2 = 0; r2 < 9; ++r2){
				
				switch (currentLine2[r2]){
				
					case 1: check[0] = 1;
						break;
					case 2: check[1] = 1;
						break;
					case 3: check[2] = 1;
						break;
					case 4: check[3] = 1;
						break;
					case 5: check[4] = 1;
						break;
					case 6: check[5] = 1;
						break;
					case 7: check[6] = 1;
						break;
					case 8: check[7] = 1;
						break;
					case 9: check[8] = 1;
						break;
					default:valid2 = 0;
						break;
				}
			}
			
			for (r2 = 0; r2 < 9; ++r2){
				
				if (check[r2] != 1){
					
					valid2 = 0;
				}
			}
			
			if (valid2 == 0){
				
				for (int i = 0; i < currentLine2.length; i++){
					if (currentLine2[i] == 1)
						++ones;
					if (currentLine2[i] == 2)
						++twos;
					if (currentLine2[i] == 3)
						++threes;
					if (currentLine2[i] == 4)
						++fours;
					if (currentLine2[i] == 5)
						++fives;
					if (currentLine2[i] == 6)
						++sixes;
					if (currentLine2[i] == 7)
						++sevens;
					if (currentLine2[i] == 8)
						++eights;
					if (currentLine2[i] == 9)
						++nines;
				}
				if (ones == 0)
					System.out.println("Row "+ invalidNum + " Column "+ (c2+1) +" should be 1");
				if (twos == 0)
					System.out.println("Row "+ invalidNum + " Column "+ (c2+1) +" should be 2");
				if (threes == 0)
					System.out.println("Row "+ invalidNum + " Column "+ (c2+1) +" should be 3");
				if (fours == 0)
					System.out.println("Row "+ invalidNum + " Column "+ (c2+1) +" should be 4");
				if (fives == 0)
					System.out.println("Row "+ invalidNum + " Column "+ (c2+1) +" should be 5");
				if (sixes == 0)
					System.out.println("Row "+ invalidNum + " Column "+ (c2+1) +" should be 6");
				if (sevens == 0)
					System.out.println("Row "+ invalidNum + " Column "+ (c2+1) +" should be 7");
				if (eights == 0)
					System.out.println("Row "+ invalidNum + " Column "+ (c2+1) +" should be 8");
				if (nines == 0)
					System.out.println("Row "+ invalidNum + " Column "+ (c2+1) +" should be 9");

			}
			
			++c2;
			valid2 = 1;
			
			for (r2 = 0; r2 < 9; ++r2) {
				
				check[r2] = 0;
			}
			ones = 0;
			twos = 0; 
			threes = 0;
			fours = 0;
			fives = 0;
			sixes = 0;
			sevens = 0;
			eights = 0;
			nines = 0;
			
		}
	}

}
