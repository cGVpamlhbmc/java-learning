package collections;

import java.util.*;

public class ListDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		System.out.println(list);
		
		
		
	}

	public class People{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}		
	}
	
}
