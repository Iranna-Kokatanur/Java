package com.executors;

public class Factorial {
	
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
		
//		for(int i = 1; i<10; i++) {
//			System.out.println(factorial(i));
//		}
		
		Thread[] thread = new Thread[9];
		
		for(int i = 1; i<10; i++) {
			int finalI = i;
			thread[i-1] = new Thread(() -> System.out.println(factorial(finalI)));
			thread[i-1].start();
		}
		
		for(Thread th: thread) {
			try {
				th.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.println("Total time: " + (System.currentTimeMillis() - start));
		
	}

}
