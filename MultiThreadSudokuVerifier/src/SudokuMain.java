/*Created By: Madison Pahl
 *File name: SudokuMain.java
 *Date Created: 03/04/2017
 *Date Completed: 03/07/2017
 */

import threadValidator.*;

import java.io.*;


class SudokuMain{

	public static void main(String[] args){
		
		ReadIn read = new ReadIn();
		
		int[][] solution = new int[9][9];
		int[] data = ReadIn.getArray();
		
		BufferedReader reader;
	       
		try {

			reader = new BufferedReader(new FileReader("Testfile5.txt"));
			
			String line = null;
			
			int r = 0; 
			int c = 0;
			
			while ((line = reader.readLine()) != null){
				
				read.setArray(line);
				data = ReadIn.getArray();
	
				for (r = 0; r < 9 ; ++r){

	        			solution[c][r] = data[r];
	        		}
				
	        		++c;
		        }
		
			
		    //creation of 11 threads rows, columns, and for each sub-square
			Thread checkRow = new Thread(new RowCheck(solution), "checkRow");
			Thread checkColumn = new Thread(new ColumnCheck(solution), "checkColumn");
			Thread checkSquare1 = new Thread(new SquareCheck(solution,0,2,0,2), "checkSquare1");
			Thread checkSquare2 = new Thread(new SquareCheck(solution,0,2,3,5), "checkSquare2");
			Thread checkSquare3 = new Thread(new SquareCheck(solution,0,2,6,8), "checkSquare3");
			Thread checkSquare4 = new Thread(new SquareCheck(solution,3,5,0,2), "checkSquare4");
			Thread checkSquare5 = new Thread(new SquareCheck(solution,3,5,3,5), "checkSquare5");
			Thread checkSquare6 = new Thread(new SquareCheck(solution,3,5,6,8), "checkSquare6");
			Thread checkSquare7 = new Thread(new SquareCheck(solution,6,8,0,2), "checkSquare7");
			Thread checkSquare8 = new Thread(new SquareCheck(solution,6,8,3,5), "checkSquare8");
			Thread checkSquare9 = new Thread(new SquareCheck(solution,6,8,6,8), "checkSquare9");
			Thread foundSolution = new Thread(new FoundSolution(solution), "foundSolution");
			
			//initiation of threads
			//join makes sure that the thread is done before moving forward
			checkRow.start();
			checkColumn.start();

			try{
				checkRow.join();
				checkColumn.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			checkSquare1.start();
			
			try{
				checkSquare1.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			checkSquare2.start();
			
			try{
				checkSquare2.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			checkSquare3.start();
			
			try{
				checkSquare3.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			checkSquare4.start();
			
			try{
				checkSquare4.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			checkSquare5.start();
			
			try{
				checkSquare5.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			checkSquare6.start();
			
			try{
				checkSquare6.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			checkSquare7.start();
			
			try{
				checkSquare7.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			checkSquare8.start();
			
			try{
				checkSquare8.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			checkSquare9.start();
			
			try{
				checkSquare9.join();
			}
			
			catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
			foundSolution.start();
			
			try{
				
				foundSolution.join();
			}
			
			catch(InterruptedException ie) {
				
				ie.printStackTrace();
			}
			
		}
		
		catch(IOException ex) {
			
			System.out.println("There has been an IO error.");
		}
	  }
	}

