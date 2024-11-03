package com.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Executor3 {
	
public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Callable<Integer> call1 = () -> {Thread.sleep(1000); return 1;};
		Callable<Integer> call2 = () -> {Thread.sleep(1000); return 2;};
		Callable<Integer> call3 = () -> {Thread.sleep(1000); return 3;};
		
		List<Callable<Integer>> list = Arrays.asList(call1, call2, call3);
		
		ExecutorService ser = Executors.newFixedThreadPool(2);
		
		Integer i = ser.invokeAny(list); // It will return any of the result which is completed first
		
		System.out.println(i);
		
		ser.shutdown();
		
		System.out.println("Hello World"); // it will print once the all the process of futures completed because of invokeAll
	}

}
