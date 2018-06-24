/*Created By: Madison Pahl
 *File name: MainScheduler.java
 *Date Created: 05/1/2017
 *Date Completed: 05/4/2017
 */

import java.io.*;

public class MainScheduler extends Thread {
	
	int overrun0 = 0;
	int overrun1 = 0;
	int overrun2 = 0;
	int overrun3 = 0;
	int status = 1;
	
	Semaphore semaphoreSchedule;
	
	Thread0 thread0;
	Thread1 thread1;
	Thread2 thread2;
	Thread3 thread3;
	
	
	
	MainScheduler(){
		
		thread0 = new Thread0(new Semaphore(), this);
		thread1 = new Thread1(new Semaphore(), this);
		thread2 = new Thread2(new Semaphore(), this);
		thread3 = new Thread3(new Semaphore(), this);
		

	}
	
	

	public static void main(String[] args) {
		
		MainScheduler schedule = new MainScheduler();
		
		schedule.semaphoreSchedule = new Semaphore();
		
		schedule.start();

	}
	
	public void run() {
		
		thread0.start();
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		while (status <= 160) {
			
			try {
				
				Thread.sleep(10);
				
			} catch (Exception exception) {}
			
			if (status % 16 ==0){
				
				if (!thread0.run) {
					
					thread0.semaphore.signal();
					
					try {
						
						this.semaphoreSchedule.waiting();	
					
					} catch (Exception exception) {}
					
					}
			
				else {
					
					++overrun0;
				}
				
				if (!thread1.run) {
				
					thread1.semaphore.signal();
				
					try { 
					
						this.semaphoreSchedule.waiting();
					
					} catch (Exception exception) {}
				}
			
				else {
				
					++overrun1;
				}
			
				if (!thread2.run) {
				
					thread2.semaphore.signal();
				
					try { 
					
						this.semaphoreSchedule.waiting();
					
					} catch (Exception exception) {}
				}
			
				else {
				
					++overrun2;
				}
			
				if (!thread3.run) {
				
					thread3.semaphore.signal();
				
					try { 
					
						this.semaphoreSchedule.waiting();
					
					} catch (Exception exception) {}
				}
			
				else {
				
					++overrun3;
				}
				
			}
			
			else if (status % 4 == 0) {
				
				if (!thread0.run) {
					
					thread0.semaphore.signal();
					
					try {
						
						this.semaphoreSchedule.waiting();	
					
					} catch (Exception exception) {}
					
					}
			
				else {
					
					++overrun0;
				}
				
				if (!thread1.run) {
				
					thread1.semaphore.signal();
				
					try { 
					
						this.semaphoreSchedule.waiting();
					
					} catch (Exception exception) {}
				}
			
				else {
				
					++overrun1;
				}
			
				if (!thread2.run) {
				
					thread2.semaphore.signal();
				
					try { 
					
						this.semaphoreSchedule.waiting();
					
					} catch (Exception exception) {}
				}
			
				else {
				
					++overrun2;
				}
				
			}
			
			else if (status % 2 == 0) {
				
				if (!thread0.run) {
					
					thread0.semaphore.signal();
					
					try {
						
						this.semaphoreSchedule.waiting();	
					
					} catch (Exception exception) {}
					
					}
			
				else {
					
					++overrun0;
				}
				
				if (!thread1.run) {
				
					thread1.semaphore.signal();
				
					try { 
					
						this.semaphoreSchedule.waiting();
					
					} catch (Exception exception) {}
				}
			
				else {
				
					++overrun1;
				}
			}
			
			else {
				
				if (!thread0.run) {
					
					thread0.semaphore.signal();
					
					try {
						
						this.semaphoreSchedule.waiting();	
					
					} catch (Exception exception) {}
					
					}
			
				else {
					
					++overrun0;
				}
			}
			
			status +=1;
		}
		
		try {
			
			outputs();
			
		} catch (Exception exception) {}
		
		System.exit(0);
	}
	
	public void outputs() throws IOException {
		
		System.out.println("Thread 0:");
		System.out.println("    Times Ran: " + thread0.counter );
		System.out.println("    Overruns:  " + overrun0);
		System.out.println("    Running time: " + thread0.totalTime + " nanoseconds");
		
		System.out.println("Thread 1:");
		System.out.println("    Times Ran: " + thread1.counter );
		System.out.println("    Overruns:  " + overrun1);
		System.out.println("    Running time: " + thread1.totalTime + " nanoseconds");
		
		System.out.println("Thread 2:");
		System.out.println("    Times Ran: " + thread2.counter );
		System.out.println("    Overruns:  " + overrun2);
		System.out.println("    Running time: " + thread2.totalTime + " nanoseconds");
		
		System.out.println("Thread 3:");
		System.out.println("    Times Ran: " + thread3.counter );
		System.out.println("    Overruns:  " + overrun3);
		System.out.println("    Running time: " + thread3.totalTime + " nanoseconds");
	}
	
	public void start() {
		
		Thread thread = new Thread(new MainScheduler());
		thread.start();
	}
	
	public void print (Object i) {
		
		System.out.println(i);
	}
}
