package com.multithreading.interview;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockPart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantLock l=new ReentrantLock();
		l.lock();
		l.lock();
		System.out.println(l.getHoldCount());
		System.out.println(l.isLocked());
		System.out.println(l.isHeldByCurrentThread());
		l.unlock();
		System.out.println(l.getHoldCount());
		System.out.println(l.isLocked());
		l.unlock();
		System.out.println(l.isLocked());
		System.out.println(l.isFair());

	}

}
