package concurrency;

public class HelloThread extends Thread {

	public static void main(String[] args) {
		(new HelloThread()).start();
		System.out.println("Hello from main");
	}

	public void run() {
		System.out.println("Hello from a thread!");
	}
	
}
