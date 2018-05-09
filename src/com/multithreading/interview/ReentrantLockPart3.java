package com.multithreading.interview;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockPart3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread2 t1=new MyThread2("FirstThread");
		MyThread2 t2=new MyThread2("SecondThread");
		t1.start();
		t2.start();

	}

}
class MyThread2 extends Thread{
	static ReentrantLock l=new ReentrantLock();
	public MyThread2(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(l.tryLock())
		{
			System.out.println(Thread.currentThread().getName()+"..got lock");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			l.unlock();
		}
		else {
			System.out.println(Thread.currentThread().getName()+"..performing alternative operations");
			
		}
		
	}
	
}
