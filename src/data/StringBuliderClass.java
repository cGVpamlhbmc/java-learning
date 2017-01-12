package data;

public class StringBuliderClass {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.capacity());
		sb.append("abcdefghijklmnopqrstuvwxyz");
		System.out.println(sb.capacity());
		
		StringBuilder sb2 = new StringBuilder("Dot saw I was Tod");
		System.out.println(sb2.capacity());
		System.out.println(sb2.toString());
		sb2.reverse();
		System.out.println(sb2.toString());
		
	}
}
