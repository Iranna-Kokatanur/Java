package com.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

	private int balance = 100;
	
	private final Lock lock = new ReentrantLock();
	
	/*public synchronized void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
		
		if(balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " proceeding with withdrawl");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " completed. remaining balance:" + balance);
		}else {
			System.out.println(Thread.currentThread().getName() + " Insufficient balance");
		}
	}*/
	
	public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
		try {
			// Asking other threads to wait for 1000 ms, but trans is taking more than 1000 ms then other threads will not wait
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
				if(balance >= amount) {
					System.out.println(Thread.currentThread().getName() + " proceeding with withdrawl");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}finally {
						lock.unlock();
					}
					balance -= amount;
					System.out.println(Thread.currentThread().getName() + " completed. remaining balance:" + balance);
				}else {
					System.out.println(Thread.currentThread().getName() + " Insufficient balance");
				}
			}else {
				System.out.println(Thread.currentThread().getName() + " could not acquire the lock. Try Later..");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
}
