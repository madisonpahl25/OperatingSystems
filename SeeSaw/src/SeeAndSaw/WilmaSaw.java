/*Created By: Madison Pahl
 *File name: WilmaSaw.java
 *Date Created: 03/22/2017
 *Date Completed: 03/25/2017
 */

package SeeAndSaw;

import java.util.concurrent.Semaphore;

public class WilmaSaw implements Runnable{
	
	Semaphore semaphoreWilma;
	Semaphore semaphoreFred;
	
	public int minHeight = 1;
	public int maxHeight = 7;
	
	//fred goes up at 1ft/sec
	//wilma goes up at 1.5ft/sec
	
	public float currentHeightF = 7;
	public float currentHeightW = 1;
	
	public WilmaSaw(Semaphore semaphoreWilma, Semaphore semaphoreFred){
		
		this.semaphoreWilma = semaphoreWilma;
		this.semaphoreFred = semaphoreFred;
		
	}
	
	public void run(){
		
		for(int i = 1; i<= 10; ++i) {
			try {
				semaphoreWilma.acquire();
				System.out.println(" ");
				System.out.println("WILMA IS GOING UP");
				System.out.println("FRED IS COMING DOWN");
				System.out.println(" ");
				
				
				while (currentHeightW < maxHeight){
					
					currentHeightW += 1.5;
					currentHeightF -= 1.5;

					System.out.println("Wilma is at" + currentHeightW + "ft.");
					System.out.println("Fred is at" + currentHeightF + "ft.");
					Thread.sleep(1000);
				
				}
				currentHeightW = 1;
				currentHeightF = 7;
				Thread.sleep(1000);
				semaphoreFred.release();
				
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
