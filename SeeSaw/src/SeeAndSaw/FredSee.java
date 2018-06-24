/*Created By: Madison Pahl
 *File name: FredSee.java
 *Date Created: 03/22/2017
 *Date Completed: 03/25/2017
 */

package SeeAndSaw;

import java.util.concurrent.Semaphore;

public class FredSee implements Runnable {
	
	
	public int minHeight = 1;
	public int maxHeight = 7;
	
	//fred goes up at 1ft/sec
	//wilma goes up at 1.5ft/sec

	public int currentHeightF = 1;
	public int currentHeightW = 7;
	
	Semaphore semaphoreFred;
	Semaphore semaphoreWilma;
	
	public FredSee(Semaphore semaphoreFred, Semaphore semaphoreWilma) {
		
		this.semaphoreFred = semaphoreFred;
		this.semaphoreWilma = semaphoreWilma;

		}
	
	public void run() {
		
		for (int i = 1; i <= 10; ++i) {
			
			try {
				
				semaphoreFred.acquire();
				System.out.println(" ");
				System.out.println("FRED IS GOING UP");
				System.out.println("WILMA IS COMING DOWN");
				System.out.println(" ");
				
				while (currentHeightF < maxHeight){
					
					currentHeightF += 1;
					currentHeightW -= 1;

					System.out.println("Fred is at" + currentHeightF + "ft.");
					System.out.println("Wilma is at" + currentHeightW + "ft.");
					Thread.sleep(1000);
				
				}
				currentHeightF = 1;
				currentHeightW = 7;
				Thread.sleep(1000);
				semaphoreWilma.release();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

	
	
	
}
