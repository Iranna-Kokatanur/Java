
public class HelloWorld2 implements Runnable{

	@Override
	public void run() {
		
		for(;;) {
			System.out.println(Thread.currentThread().getName());
		}
		
	}

}
