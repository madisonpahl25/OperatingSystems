/*Created By: Madison Pahl
 *File name: SquareCheck.java
 *Date Created: 03/04/2017
 *Date Completed: 03/07/2017
 */

package threadValidator;

public class SquareCheck implements Runnable{

    private int[][] solution = new int[9][9];
    private int[] check = new int[9];

    private int valid;
    private int startRow;
    private int endRow;
    private int startColumn;
    private int endColumn;
    private int subsquare;

    public SquareCheck(int[][] data, int rowStart, int rowEnd, int columnStart, int columnEnd){

		this.solution = data;
		this.valid = 1;
		this.startRow = rowStart;
		this.endRow = rowEnd;
		this.startColumn = columnStart;
		this.endColumn = columnEnd;

        int i = 0;

        for (i = 0; i < 9; ++i){
        	
			check[i] = 0;
		}
    }

    public void run(){
    	
    	//r is for the row and c is for the column
    	int c = startColumn;
    	int r = startRow;
    	
    	int count = 0;
        int[] currentLine = new int[9];
        while (c <= endColumn){
        	
	        while (r <= endRow){

	            currentLine[count] = solution[r][c];
	            ++r;
	            ++count;
       		}
	        
       		r = startRow;
       		++c;
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
			
			if (check[r] != 1) {
				
				valid = 0;
			} 
		}
        
        if (startRow == 0 & startColumn == 0){
        	
        	subsquare = 1;
        }
        
        if (startRow == 0 & startColumn == 3){
        	
        	subsquare = 2;
        }
        
        if (startRow == 0 & startColumn == 6){
        	
        	subsquare = 3;
        }
        
        if (startRow == 3 & startColumn == 0){
        	
        	subsquare = 4;
        }
        
        if (startRow == 3 & startColumn == 3){
        	
        	subsquare = 5;
        }
        
        if (startRow == 3 & startColumn == 6){
        	
        	subsquare = 6;
        }
        
        if (startRow == 6 & startColumn == 0){
        	
        	subsquare = 7;
        }
        
        if (startRow == 6 & startColumn == 3){
        	
        	subsquare = 8;
        }
        
        if (startRow == 6 & startColumn == 6){
        	
        	subsquare = 9;
        }
		
		//if multiples are found or an number is not included error statement provided
		if (valid == 0){
			
			System.out.println("You have an error in sub-square: " +subsquare);
		}
		
		//in the case of no error in square, the user is notified
		else{
			
			System.out.println("Your sub-square: " + subsquare + " is Valid!");
		}        
    }
}
