package com.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Executor2 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Callable<Integer> call1 = () -> {Thread.sleep(1000); return 1;};
		Callable<Integer> call2 = () -> {Thread.sleep(1000); return 2;};
		Callable<Integer> call3 = () -> {Thread.sleep(1000); return 3;};
		
		List<Callable<Integer>> list = Arrays.asList(call1, call2, call3);
		
		ExecutorService ser = Executors.newFixedThreadPool(2);
		
		List<Future<Integer>> futures = ser.invokeAll(list, 1, TimeUnit.SECONDS); // invokeAll will block the main thread means first these will get execute later other will
		
		// Here threads will execute in first 1 second when threads becomes free and try to execute call3 there is a exception
		
		// because invokeAll waiting for only 1 sec but call3 is getting after 1 second
		
		for(Future<Integer> f: futures) {
			System.out.println(f.get());
		}
		
		ser.shutdown();
		
		System.out.println("Hello World"); // it will print once the all the process of futures completed because of invokeAll
	}

}
