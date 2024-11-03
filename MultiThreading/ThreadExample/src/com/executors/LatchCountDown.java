package com.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class DependentService implements Callable<String>{
	
	private final CountDownLatch latch;
	
	public DependentService(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() +" is started");
		try {
			Thread.sleep(2000);
		}finally {
			latch.countDown();
		}
		return "ok";
		
	}
	
	
}

public class LatchCountDown {

	
	public static void main(String[] args) throws InterruptedException {
		
		// CountDownLatch -> If you want to do wait from Main thread for the services, you can do future.get for all the three service
		// instead of that you can do CountDownLatch
		
		// you can do this with thread also
		
		int numberOfService = 3;
		
		ExecutorService service = Executors.newFixedThreadPool(numberOfService);
		CountDownLatch latch = new CountDownLatch(numberOfService);
		service.submit(new DependentService(latch));
		service.submit(new DependentService(latch));
		service.submit(new DependentService(latch));
		
		latch.await(5, TimeUnit.SECONDS);
		
		System.out.println("MAIN");
		service.shutdown();
		
	}

}
