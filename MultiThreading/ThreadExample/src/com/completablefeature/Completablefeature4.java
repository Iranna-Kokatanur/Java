package com.completablefeature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Completablefeature4 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// CompeletableFeature is daemon thread by default, do .get on it to get wait by main thread
		
		String f1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
				System.out.println("WORKER");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "ok";
		}).get();
		
		// you can do get there only
		
		
		
		// it will do the apply after the process of thread.sleep(5000)
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
				System.out.println("WORKER");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "ok";
		}).thenApply(x -> x + x);
		
		System.out.println(f2.get());
	
		
	}

}
