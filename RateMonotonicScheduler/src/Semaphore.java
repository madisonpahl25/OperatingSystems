/*Created By: Madison Pahl
 *File name: Semaphore.java
 *Date Created: 05/1/2017
 *Date Completed: 05/4/2017
 */

public class Semaphore {
	
public int val;
	
	Semaphore(){
		
		this.val = 0;
	}
	
	public synchronized void signal(){
		notifyAll();
		++this.val;
		
	}
	
	public synchronized void waiting() throws InterruptedException{
		
		while (this.val <= 0) {
			
			wait();
		}
		
		--this.val;
	}
}
