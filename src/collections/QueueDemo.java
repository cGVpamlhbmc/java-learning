package collections;

import java.util.*;

public class QueueDemo {

	public static void main(String[] args) throws InterruptedException {
		int time = 10;// Integer.parseInt(args[0]);
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = time; i >= 0; i--) {
			queue.add(i);
		}
		while (!queue.isEmpty()) {
			System.out.println(queue.remove());
			Thread.sleep(1000);
		}
	}

}
