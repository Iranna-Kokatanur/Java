package com.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
	
	private final Lock lock = new ReentrantLock();
	
	public void outerMethod() {
		lock.lock();
		
		try {
			System.out.println("outer method");
			innerMethod();
		}catch(Exception e) {
			
		}finally {
			lock.unlock();
		}
	}

	private void innerMethod() {
	
		lock.lock();
		try {
			System.out.println("inner method");
		}catch(Exception e) {
			
		}finally {
			lock.unlock();
		}
		
	}
	
	public static void main(String[] args) {
		ReentrantExample ex = new ReentrantExample();
		ex.outerMethod();
		
		// Reentrant lock means 
		
		//lock, unlock, trylock, deadlock prevention, lock interruptible
	}

}
