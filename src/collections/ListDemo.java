package collections;

import java.util.*;
import java.util.stream.Collectors;

public class ListDemo {

	public static void main(String[] args) {
		// List<String> list = new ArrayList<String>();
		// list.add("Hello");
		// list.add("World");
		// System.out.println(list);
		ListDemo listDemo = new ListDemo();
		People p1 = listDemo.new People("John");
		People p2 = listDemo.new People("Peter");
		People p3 = listDemo.new People("Tony");
		List<People> persons = new ArrayList<People>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		List<String> names = persons.stream().map(People::getName).collect(Collectors.toList());
		names.forEach(System.out::println);
	}

	class People {

		public People(String name) {
			this.name = name;
		}

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
