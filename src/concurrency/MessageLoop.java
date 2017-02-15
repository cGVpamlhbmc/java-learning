package concurrency;

public class MessageLoop implements Runnable {

	@Override
	public void run() {
		String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy",
				"A kid will eat ivy too" };
		String threadName = Thread.currentThread().getName();
		
		try {
			for (int i = 0; i < importantInfo.length; i++) {
				Thread.sleep(3000);
				System.out.format("%s: %s%n", threadName, importantInfo[i]);
			}
		} catch (InterruptedException e) {
			System.out.format("%s: %s%n", threadName, "I wasn't done!");
		}
	}
	
}
