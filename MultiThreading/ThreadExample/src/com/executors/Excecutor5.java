package com.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Excecutor5 {
	
	public static void main(String[] args) {
		ExecutorService ser = Executors.newSingleThreadExecutor();
		Future<Integer> f = ser.submit(() -> {
			Thread.sleep(2000);
			System.out.println("Hello");
			return 42;
		});
		
		f.cancel(true); //add whether to interrupt or not in input of cancel -> We added as true so it will not execute the task
		
		System.out.println(f.isCancelled());
		System.out.println(f.isDone()); // it will return true if it cancelled or completed or errored just task is done or not
		
		ser.shutdown();
	}

}
