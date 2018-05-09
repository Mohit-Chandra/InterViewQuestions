package com.multithreading.interview;



/**
 * @author mohit
 * Without sychronized keyword irregular output.
 *
 */
public class SynchronizedPart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display d=new Display();
		MyThread t1=new MyThread(d,"Mohit");
		MyThread t2=new MyThread(d,"Ankit");
		Thread thread1=new Thread(t1);
		Thread thread2=new Thread(t2);
		thread1.start();
		thread2.start();
		

	}

}
class MyThread implements Runnable{
	Display d;
	String name;
	

	public MyThread(Display d, String name) {
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
class Display
{
	public synchronized void wish(String name)
	{
		for(int i=0;i<10;i++)
		{
			System.out.print("Good Morning: ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}