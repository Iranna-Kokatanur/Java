package com.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Excecutors {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Callable<Integer> callable = () -> 42;
		
		Future<Integer> future = service.submit(callable); // Future<?> -> ? knows the integer type
		
		System.out.println(future.get()); // waits for the computation for the result and print the result
		
		System.out.println(future.get(1, TimeUnit.SECONDS));
		
		// .get method wait by main thread
		
		if(future.isDone()) {
			System.out.println("Is done");
		}
		
		service.shutdown();
		
		Thread.sleep(1000);
		
		System.out.println(service.isTerminated()); // it will execute immediately so we added Thread.sleep to complete the task
		
	}

}
