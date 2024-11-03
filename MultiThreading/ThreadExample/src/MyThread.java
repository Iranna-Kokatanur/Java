
public class MyThread extends Thread{
	
	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("RUNNING");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
	}

	
	public static void main(String[] args) throws InterruptedException {
		
		MyThread t1 = new MyThread("Custom");
		System.out.println(t1.getState() + t1.getName());
		t1.start();
		System.out.println(t1.getState());
		Thread.sleep(100);
		System.out.println(t1.getState());
		t1.join();
		System.out.println(t1.getState());
	}
}
