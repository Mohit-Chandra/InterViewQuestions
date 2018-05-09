package com.multithreading.interview;

import java.util.concurrent.locks.ReentrantLock;


/**
 * @author mohit
 * Synchronization using ReentrantLock
 * If we will comment line 1 and 2 we will get irregular output.
 *
 */
public class ReentrantLockPart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display1 d=new Display1();
		MyThread1 t1=new MyThread1(d,"Mohit");
		MyThread1 t2=new MyThread1(d,"Ankit");
		Thread thread1=new Thread(t1);
		Thread thread2=new Thread(t2);
		thread1.start();
		thread2.start();
		

	}

}
class MyThread1 implements Runnable{
	Display1 d;
	String name;
	

	public MyThread1(Display1 d, String name) {
		super();
		this.d = d;
		this.name = name;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		d.wish(name);
		
	}
	
}
class Display1
{
	static ReentrantLock l=new ReentrantLock();
	public void wish(String name)
	{
		l.lock();  //--->1
		for(int i=0;i<10;i++)
		{
			System.out.print("Good Morning:");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
		}
		l.unlock();//-->2
	}
}
