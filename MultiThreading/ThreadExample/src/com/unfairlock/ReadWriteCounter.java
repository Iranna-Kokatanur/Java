package com.unfairlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

public class ReadWriteCounter {
	
	private int count = 0;
	
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private Lock readLock = lock.readLock();
	
	private Lock writeLock = lock.writeLock();
	
	public void increment() {
		writeLock.lock();
		try {
			count++;
		}finally {
			writeLock.unlock();
		}
	}
	
	public int getCount() {
		readLock.lock();
		try {
			return count;
		}finally {
			readLock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReadWriteCounter counter = new ReadWriteCounter();
		
		Runnable readTask = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<10; i++) {
					System.out.println(Thread.currentThread().getName() + " read: " + counter.getCount());
				}
			}
		};
		
		Runnable writeTask = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i<10; i++) {
					counter.increment();
					System.out.println(Thread.currentThread().getName() + " incremented");
				}
			}
		};
		
		Thread writeThread1 = new Thread(writeTask);
		Thread readThread1 = new Thread(readTask);
		Thread readThread2 = new Thread(readTask);
		
		writeThread1.start();
		readThread1.start();
		readThread2.start();
		
		writeThread1.join();
		readThread1.join();
		readThread2.join();
		
		System.out.println("final count" + counter.getCount());
		
		//Multiple threads can acquire the read lock until any other not require the write lock
		
		// Multiple threads no need to wait for read locks, until any other thread acquire the write lock 
		// because they will communicate each other
	}

}
