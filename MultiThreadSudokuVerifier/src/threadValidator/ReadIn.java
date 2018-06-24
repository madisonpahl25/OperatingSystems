/*Created By: Madison Pahl
 *File name: ReadIn.java
 *Date Created: 03/04/2017
 *Date Completed: 03/07/2017
 */

package threadValidator;

public class ReadIn {
    private String currentLine;
    private static int[] lineData = new int[9];

    public ReadIn() {
	this.currentLine = "";
        int i = 0;
        for (i = 0; i < 9; i++) {
            lineData[i] = i + 1;
        }
    }

    private void setCurrentLine (String inputLine) {
        currentLine = inputLine;
    }
    
    public void setArray (String inputLine) {
        this.setCurrentLine (inputLine);
        String[] parts = currentLine.split(",");
	int i = 0;
	Integer numVal = 0;

	for (i = 0; i < 9; i++) {
	    numVal = Integer.valueOf(parts[i]);
	    lineData[i] = numVal;	    	    
	}
    }

    public static int[] getArray() {
        return lineData;
    }
    

}
