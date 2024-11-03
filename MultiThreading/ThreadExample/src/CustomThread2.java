
public class CustomThread2 extends Thread{
	
	@Override
	public void run() {
		
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() +" is running.." );
			Thread.yield();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		CustomThread2 t1 = new CustomThread2();
		CustomThread2 t2 = new CustomThread2();
		t1.start();
		t2.start();
		
		// Yield will give the option for other threads to execute
	}

}
