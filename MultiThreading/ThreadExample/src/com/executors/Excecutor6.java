package com.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Excecutor6 {
	
	public static void main(String[] args) {
		ExecutorService ser = Executors.newSingleThreadExecutor();
		Future<Integer> f = ser.submit(() -> {
			Thread.sleep(2000);
			System.out.println("Hello");
			return 42;
		});
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		f.cancel(false); //add whether to interrupt or not in input of cancel -> we added as false it will cancel but meanwhile it will execute the execute the task
		
		
		System.out.println(f.isCancelled());
		System.out.println(f.isDone()); // it will return true if it cancelled or completed or errored just task is done or not
		
		ser.shutdown();
	}

}
