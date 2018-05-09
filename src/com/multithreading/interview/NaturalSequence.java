package com.multithreading.interview;

public class NaturalSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isEven=false;
		PrintInSequence printInSequence=new PrintInSequence(isEven);
		Thread eventhread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					printInSequence.printEven();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		eventhread.start();
		Thread oddThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					printInSequence.printOdd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		oddThread.start();

	}

}
class PrintInSequence
{
	boolean isEven;
	public PrintInSequence(boolean isEven) {
		// TODO Auto-generated constructor stub
		this.isEven=isEven;
	}

	public void printOdd() throws InterruptedException {
		// TODO Auto-generated method stub
		synchronized (this) {
			while(!isEven)
			{
				for(int i=1;i<=10;i+=2) {
					isEven=true;
					System.out.println("Odd: "+i);
					this.wait();
				}
				this.notify();
			}
			
		}
		
	}

	public void printEven() throws InterruptedException
	{
		synchronized (this) {
			if(isEven)
			{
				for(int i=2;i<=10;i+=2) {
					isEven=false;
					System.out.println("Even: "+i);
					break;
				}
				this.notify();
			}
			else {
				this.wait();
			}
			
		}
	}
}
