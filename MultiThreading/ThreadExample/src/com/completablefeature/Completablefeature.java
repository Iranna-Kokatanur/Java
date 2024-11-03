package com.completablefeature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Completablefeature {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// CompeletableFeature is daemon thread by default, do .get on it to get wait by main thread
		
		CompletableFuture f1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(2000);
				System.out.println("WORKER");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return "ok";
		});
		
		f1.get();
		
		System.out.println("MAIN");
		
	}

}
