package concurrency;

public class InterrupteThread {
	public static void main(String[] args) {
		Thread thread = new Thread(new MessageLoop());		

		System.out.println("main start");
		thread.start();		
		thread.interrupt();
		System.out.println("main end");
	}
}
