package generics;

import java.util.*;

public class WildCardDemo {
	public static void process(List<? extends Integer> list) {
		for (Integer elem : list) {
			System.out.println(elem);
		}
	}

	public static double sumOfList(List<? extends Number> list) {
		double s = 0.0;
		for (Number n : list)
			s += n.doubleValue();
		return s;
	}

	public static void addNumbers(List<? super Integer> list) {
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
	}

	public static void printList(List<?> list) {
		for (Object elem : list)
			System.out.print(elem + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// List<Integer> list = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		// process(list);
		//
		// List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		// System.out.println("sum = " + sumOfList(ld));

		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String> ls = Arrays.asList("one", "two", "three");
		printList(li);
		printList(ls);

		List<? extends Integer> intList = new ArrayList<>();
		List<? extends Number> numberList = intList;
	}
}
