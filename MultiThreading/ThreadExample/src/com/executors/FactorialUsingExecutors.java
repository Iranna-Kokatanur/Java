package com.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FactorialUsingExecutors {
	
	private static int factorial(int n) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		int res = 1;
		
		for(int i = 2; i<=n; i++) res *= i;
		
		return res;
	}
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for(int i = 1; i<10; i++) {
			int finalI = i;
			executorService.submit(() -> System.out.println(factorial(finalI)));
		}
		
		//It will shutdown the completed tasks 
		executorService.shutdown();
		
		try {
			// It will wait 100 seconds for completing the executorService tasks
			executorService.awaitTermination(100, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
		System.out.println("Total time: " + (System.currentTimeMillis() - start));
		
	}

}
