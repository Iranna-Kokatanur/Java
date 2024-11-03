package com.unfairlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {
	
	private final Lock unfairLock = new ReentrantLock();
	
	public void accessResouce() {
		unfairLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " acquired the lock.");
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}finally {
			System.out.println(Thread.currentThread().getName() + " released the lock.");
			unfairLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		UnfairLockExample ex = new UnfairLockExample();
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
		
	}

}