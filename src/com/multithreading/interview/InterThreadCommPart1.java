package com.multithreading.interview;

import java.time.Duration;
import java.time.Instant;

/**
 * @author mohit
 * created on 28th April 2018
 * This program demonstrates how we can run two threads one by one i.e.
 * after completion of one particular thread other should execute.
 * 
 * 1.child.sleep(10) --> while waiting for updation it is not best practice as performance decreases as parent 
					 thread waits unnecessarily
   2.child.join() --> Not best assume there is 1 crore lines of code after for loop wait by parent thread is unnecessary
   					Performance decreases.
   BEST SOLUTION : 
   3.child.wait() -->main thread not required to wait as updation is ready.
     this.notify() but these methods must be inside synchronized block otherwise 
     RE: IllegalMonitorStateException
   4. If child thread gets chance there is no one to notify when wait is being called so it is forever in waiting state.
      To remove this call wait(long milliseconds) so that it will continue after specified time limit and not wait forever
 *
 */

public class InterThreadCommPart1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ThreadChild child=new ThreadChild();
		child.start();
		Instant start = Instant.now();
		//child.sleep(10);
		//child.join();
		synchronized (child) {
			System.out.println("main thread calling wait() method ");
			//child.wait();//Not recommended see 4th point above
			child.wait(1000);
			System.out.println("main thread got notification");
			System.out.println(child.total);
		}
		
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
		
	}
}
class ThreadChild extends Thread{
	int total=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized (this) {
			System.out.println("Child performing calculation");
			for(int i=1;i<=100;i++)
			{
				total+=i;
			}
			this.notify();
			System.out.println("Child notifying about updation to main thread");
		}
	}
	
}

