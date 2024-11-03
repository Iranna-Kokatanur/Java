package com.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsServiceMain {
	
	public static void main(String[] args) {
		
		ScheduledExecutorService schedular = Executors.newScheduledThreadPool(1);
		
		schedular.schedule(() -> System.out.println("Task is executed after 5 seconds"), 5, TimeUnit.SECONDS);
		
		// It will run in fixed rate, means even the task takes 10 sec also or not but the schedular will repeat the task after 5 seconds period
		schedular.scheduleAtFixedRate(() -> System.out.println("Task is executed after every 5 seconds"), 5, 5, TimeUnit.SECONDS);
		
		//schedular shutdown dont know that you are running in fixed rate, it will shutdown the service. For proper
		// handling you need to handle shutdown after some delay or any other logic
		
		schedular.schedule(()->{
			System.out.println("Schedular is shutting down");
			schedular.shutdown();
		}, 20, TimeUnit.SECONDS);
		
	}

}

