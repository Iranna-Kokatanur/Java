package com.lambda;


interface example{
	
	public void giveName(String name);
}


public class Lambda {
	
	// Functional interface which have single abstract method so, we can use lamda expressions to write simpler codes
	
	public static void main(String[] args) {
		
		example example = new example() {
			
			@Override
			public void giveName(String name) {
				
				System.out.println("Hello" + name);
				
			}
		};
		
		example.giveName("iranna");
		
		// Instead of this we can try using lamda expression as example interface having one abstract method
		
		example example1 = (String name) -> {
			System.out.println("Hello1" + name);
		};
		
		example1.giveName("iranna");
		
		// or you can even simply 
		
		example example2 = (name) -> System.out.println("Hello2" + name);
		
		example2.giveName("iranna");
		
		// same for thread also we can do like this as we know Runnable interface has only one abstract method called run
		
	    Thread thread = new Thread(() -> System.out.println("Hello"));
	    
	    thread.start();
		
	}

}
