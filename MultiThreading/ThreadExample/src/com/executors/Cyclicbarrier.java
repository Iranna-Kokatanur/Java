package com.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DependentServiceForBarrier implements Callable<String>{
	
	private final CyclicBarrier barrier;
	
	public DependentServiceForBarrier(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " service started.");
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
		barrier.await();
		return "ok";
		
	}
	
	
}

public class Cyclicbarrier {
	
	public static void main(String[] args) {
		
		/**
		 * 
		 *  Here multiple/worker threads will wait for the certain point until all the other threads can come to 
		 *  that point, so that all can be released
		 *  
		 *  e.g: 2 friends are waiting near the cinema gate for his other friends who are in middle way. When they will
		 *  reach the gate all can go and see the movie
		 * 
		 */
		
		int numberOfService = 3;
		
		ExecutorService service = Executors.newFixedThreadPool(numberOfService);
		CyclicBarrier barrier = new CyclicBarrier(numberOfService);
		service.submit(new DependentServiceForBarrier(barrier));
		service.submit(new DependentServiceForBarrier(barrier));
		service.submit(new DependentServiceForBarrier(barrier));
		System.out.println("MAIN");
		service.shutdown();
	}

}
