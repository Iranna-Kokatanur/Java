
public class CustomThread3 extends Thread{
	
	@Override
	public void run() {
		
		while(true) {
			System.out.println("Hello World!!");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		CustomThread3 t1 = new CustomThread3();
		t1.setDaemon(true);
		t1.start();
		System.out.println("MAIN DONE");
		//Daemon threads -> CPU will never Daemon threads 
	}

}
