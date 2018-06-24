/*Created By: Madison Pahl
 *File name: ColumnCheck.java
 *Date Created: 03/04/2017
 *Date Completed: 03/07/2017
 */

package threadValidator;

public class ColumnCheck implements Runnable{
	
    private int[][] solution = new int[9][9];
    private int[] check = new int[9];

    private int valid;
    private int error; 

    
    public ColumnCheck(int[][] data) {

		this.solution = data;
		this.valid = 1;
		this.error = 0; 
		
        int n = 0;
        
        
        for (n = 0; n < 9; ++n) {
        	
			check[n] = 0;
		}
    }

    public void run(){
    	
    	//r is for the row and c is for the column
		int r = 0;
        int c = 0;
        
        int[] currentLine = new int[9];
        
        
        while (c < 9){
        	
	        for (r = 0; r < 9; ++r){
	        	
	            currentLine[r] = solution[r][c];
       		}
	        
        	for (r = 0; r < 9; ++r){
        		
				switch (currentLine[r]){
				
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
			
			if (check[r] != 1){
				
				valid = 0;
			} 
		}
		
		//if multiples are found or an number is not included error statement provided
		if (valid == 0){
			
			System.out.println("You have an error in column: " + (c+1));
			error = 1;
		}

		//in the case of no error in column, the user is notified
		else if (c == 8 && valid == 1 && error == 0){
			
			System.out.println("Your columns are free from errors!");
		}
		
		//moves to the next column and restart validity
        ++c;
		valid = 1;
		
		for (r = 0; r < 9; ++r){
			
          	      check[r] = 0;
  	        }
		}
    }
}
