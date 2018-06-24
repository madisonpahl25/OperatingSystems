/*Created By: Madison Pahl
 *File name: Main.java
 *Date Created: 03/22/2017
 *Date Completed: 03/25/2017
 */

import java.util.concurrent.Semaphore;
import SeeAndSaw.*;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaphoreFred = new Semaphore(1);
		Semaphore semaphoreWilma = new Semaphore(0);
		
		FredSee fredSee = new FredSee(semaphoreFred, semaphoreWilma);
		WilmaSaw wilmaSaw = new WilmaSaw(semaphoreWilma, semaphoreFred);
		
		Thread fredThread = new Thread(fredSee, "fredThread");
		Thread wilmaThread = new Thread(wilmaSaw, "wilmaThread");
		
		System.out.println("Fred and Wilma are beginning to seesaw...");
		System.out.println(" ");
		fredThread.start();
		wilmaThread.start();
		
		try{
			fredThread.join();
			wilmaThread.join();
		}
		
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
		
		System.out.println(" ");
		System.out.println("Fred and Wilma Successfully completed 10 SeeSaws!");
	}

}
