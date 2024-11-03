package com.completablefeature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Completablefeature2 {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// CompeletableFeature is daemon thread by default, do .get on it to get wait by main thread
		
		CompletableFuture f1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
				System.out.println("WORKER");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "ok";
		});
		
		CompletableFuture f2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
				System.out.println("WORKER");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "ok";
		});
		
		
		// It returns a new completable feature when both the futures completed. If any result in exceptional, final future will
		// be also exceptional
		CompletableFuture<Void> f3 = CompletableFuture.allOf(f1, f2);
		
		f3.join();
		// you can use f3.get() also here
		
		System.out.println("MAIN");
		
	}

}
