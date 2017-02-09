package concurrency;

public class HelloRunnable implements Runnable {

	public static void main(String[] args) {
		(new Thread(new HelloRunnable())).start();
		System.out.println("Hello from main");
	}

	@Override
	public void run() {
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println("Hello from a thread!");
	}

}
