package com.completablefeature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Completablefeature3 {
	
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
		
		// getnow will return the output whatever in the input like currently "not ok" because f1 is waiting 5 seconds to complete
		// so, main thread will not that much
		String val = (String) f1.getNow("not ok");
		
		System.out.println(val);
		
		System.out.println("MAIN");
		
	}

}
