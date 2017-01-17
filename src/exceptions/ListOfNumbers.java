package exceptions;

import java.io.*;
import java.util.*;

public class ListOfNumbers {
	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers() {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i));
		}
	}

	public void writeList() throws IOException, IndexOutOfBoundsException {
		// The FileWriter constructor throws IOException, which must be caught.
		PrintWriter out = null;// new PrintWriter(new
								// FileWriter("OutFile.txt"));
		try {
			System.out.println("Entered try statement");
			out = new PrintWriter(new FileWriter("OutFile.txt"));
			for (int i = 0; i < SIZE; i++) {
				// The get(int) method throws IndexOutOfBoundsException, which
				// must
				// be caught.
				out.println("Value at: " + i + " = " + list.get(i));
			}
			out.close();
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
	}

	static String readFirstLineFromFile(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}
}
