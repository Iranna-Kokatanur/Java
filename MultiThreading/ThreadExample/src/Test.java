
public class Test {
	
	public static void main(String[] args) {
		
		HelloWorld world = new HelloWorld();
		world.start();
		
		Thread th = new Thread(new HelloWorld2());
		th.start();
		
		for(;;) {
			System.out.println(Thread.currentThread().getName());
			
		}
		
		
		
	}

}
