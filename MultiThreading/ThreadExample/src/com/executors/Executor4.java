package com.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Executor4 {
	
	public static void main(String[] args) {
		
		ExecutorService ser = Executors.newSingleThreadExecutor();
		Future<Integer> f = ser.submit(() -> {
			Thread.sleep(2000);
			return 42;
		});
		
		Integer i = null;
		
		try {
			i = f.get(1, TimeUnit.SECONDS);
			System.out.println(f.isDone());
			System.out.println(i);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ser.shutdown();
		
		// here task is taking 2 seconds but we are expecting the result in 1 second so, Timeout Exception
	}

}
