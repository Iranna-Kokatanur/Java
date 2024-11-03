package com.unfairlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
	
	private final Lock fairLock = new ReentrantLock(true);
	
	public void accessResouce() {
		fairLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " acquired the lock.");
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			System.out.println(Thread.currentThread().getName() + " released the lock.");
			fairLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		FairLockExample ex = new FairLockExample();
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				
				ex.accessResouce();
			}
		};
		
		Thread thread1 = new Thread(task, "Thread 1");
		Thread thread2 = new Thread(task, "Thread 2");
		Thread thread3 = new Thread(task, "Thread 3");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		// Here everyone will get the chance in fairness locking
		
		// once if the synchronized lock -> there is no fairness, blocking will be there, no interruptibility, Read/write locking
		
	}

}