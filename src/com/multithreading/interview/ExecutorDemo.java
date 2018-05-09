package com.multithreading.interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * @author mohit
 * ExecutorService is responsible to create
 * and run threads so it increases performance
 *
 */
public class ExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintJob[] jobs= {
				new PrintJob("Mohit"),
				new PrintJob("Sumeet"),
				new PrintJob("Ankit"),
				new PrintJob("Saurav")
		};
		ExecutorService service=Executors.newFixedThreadPool(3);
		for (PrintJob printJob : jobs) {
			service.submit(printJob);
		}
		service.shutdown();
	}

}
class PrintJob implements Runnable{
	String name;
	PrintJob(String name){
		this.name=name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(name+"...Job started by Thread:"+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"...Job completed by Thread:"+Thread.currentThread().getName());
	}
}
