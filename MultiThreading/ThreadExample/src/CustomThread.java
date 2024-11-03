
public class CustomThread extends Thread{
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
			System.out.println("Thread is running...");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		CustomThread th = new CustomThread();
		th.start();
		th.interrupt();
		
	}

}
