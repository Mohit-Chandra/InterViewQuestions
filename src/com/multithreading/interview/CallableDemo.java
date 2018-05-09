package com.multithreading.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		MyCallable[] jobs= {
				new MyCallable(10),
				new MyCallable(20),
				new MyCallable(30),
				new MyCallable(40)
		};
		ExecutorService service=Executors.newFixedThreadPool(3);
		for (MyCallable printJob : jobs) {
			Future<Object>r=service.submit(printJob);
			System.out.println(r.get());
		}
		service.shutdown();

	}

}
class MyCallable implements Callable<Object>{
	int num;
	MyCallable(int num){
		this.num=num;
	}
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+".. is responsible to get the sum of first "+num+" numbers");
		int sum=0;
		for (int i = 1; i<=num; i++) {
			sum+=i;
		}
		return sum;
	}
}