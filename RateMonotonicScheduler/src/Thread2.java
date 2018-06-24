/*Created By: Madison Pahl
 *File name: Thread2.java
 *Date Created: 05/1/2017
 *Date Completed: 05/4/2017
 */

import java.util.concurrent.*;

public class Thread2 extends Thread{
	
	public Semaphore semaphore;
	public static int counter;
	public static boolean run;
	public MainScheduler scheduler;
	
	long StartTime = System.currentTimeMillis();
	public static long totalTime;
	
	public final ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
	
	
	Thread2(Semaphore sema, MainScheduler schedule) {
		this.scheduler = schedule;
		this.semaphore = sema;
		
		run = false;
		counter = 0;
		
	}
	
	public void run() {
		
		while(true) {
			
			try{
				
				this.semaphore.waiting();
				
			} catch (Exception except) {}
				
			final Runnable bck = new Runnable() {
				
				public void run() {
					
					scheduler.semaphoreSchedule.signal();
				}
				
			};
			
			timer.schedule(bck, 10, TimeUnit.MILLISECONDS);
			
			setRun(true);
			
			////Test 3 case change i to 50000 for Thread 2 to run 38 times and have 1 overrun
			
			for (int i = 0; i<4; ++i){
				
				doWork();
			}
			
			totalTime = System.currentTimeMillis() - StartTime;
			setCounter(1);
			setRun(false);
			
				
			
		}
	}
	
	public void start() {
		
		Thread thread = new Thread(new Thread2(this.semaphore, this.scheduler));
		thread.start();
	}
	
	public void setRun(boolean changeVal) {
		
		this.run = changeVal;
	}
	
	public void setCounter (int m) {
		
		this.counter += m;
	}
	
	public void print (Object i) {
		
		System.out.println(i);
	}
	
	public void doWork() {
		
		int [][] work = new int [10][10];
		
		for (int m = 0; m <= 9; ++m) {
			
			for (int n = 0; n <= 9; ++n) {
				
				work[m][n] = 1;
			}
		}
		
		int prod = 1;
		int [] col = {0,5,1,6,2,7,3,8,4,9};
		
		for (int m = 0; m <= 9; ++m) {
			
			for (int n = 0; n <= 9; ++n) {
				prod = prod * work[col[m]][n];
			}
		}
	}

}
