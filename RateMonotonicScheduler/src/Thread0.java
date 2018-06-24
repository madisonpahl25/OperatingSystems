/*Created By: Madison Pahl
 *File name: Thread0.java
 *Date Created: 05/1/2017
 *Date Completed: 05/4/2017
 */

import java.util.concurrent.*;

public class Thread0 extends Thread{
	
	public Semaphore semaphore;
	public static int counter;
	public static boolean run;
	public MainScheduler scheduler;
	
	long StartTime = System.currentTimeMillis();
	public  static long totalTime;
	
	public final ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
	
	
	Thread0 (Semaphore sema, MainScheduler schedule) {
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
			
			//Test 2 case change i to 5000 for Thread 0 to run 158 times and have 1 overrun
			//Test 2 case change i to 10000 for Thread 0 to run around 156 times and 3 overruns
			
			for (int i = 0; i<1; ++i){
				
				doWork();
			}
			totalTime = System.currentTimeMillis() - StartTime;
			setCounter(1);
			setRun(false);
			
				
			
		}
	}
	
	public void start() {
		
		Thread thread = new Thread(new Thread0(this.semaphore, this.scheduler));
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
