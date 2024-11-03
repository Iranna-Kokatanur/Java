package com.communication;

class SharedResource{
	
	private int data;
	
	private boolean hasData;
	
	public synchronized void produce(int value) {
		while(hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		this.data = value;
		hasData = true;
		System.out.println("Produced: " + value);
		notify();
	}
	
	public synchronized int consume() {
		while(!hasData) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		hasData = false;
		System.out.println("Conumed: " + data);
		notify();
		return data;
	}
}

class Producer implements Runnable{
	private SharedResource resource;
	
	public Producer(SharedResource resource) {
		// TODO Auto-generated constructor stub
		
		this.resource = resource;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i<10; i++) {
			resource.produce(i);
		}
	}

}

class Consumer implements Runnable{
	private SharedResource resource;
	
	public Consumer(SharedResource resource) {
		// TODO Auto-generated constructor stub
		
		this.resource = resource;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i<10; i++) {
			resource.consume();
		}
	}

}

public class ThreadCommunication {
	
	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		
		Thread producerThread = new Thread(new Producer(resource));
		Thread consumerThread = new Thread(new Consumer(resource));
		
		producerThread.start();
		consumerThread.start();
		
		// thread communication example here, producer will produce the data when there is no data and notify to other thread otherwise it will wait for other thread to consume
		
		// reverse case in consumer
		
		// notifyAll for more threads
	}

}
