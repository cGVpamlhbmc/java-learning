/**
 * 
 */
package data;

/**
 * @author ypj6024
 *
 */
public class StringClass {

	public static void main(String[] args) {
		String greeting = "Hello World.";
		System.out.println(greeting);

		char[] helloArray = { 'h', 'e', 'l', 'l', 'o' };
		String helloString = new String(helloArray);
		System.out.println(helloString);

		String palindrome = "Dot saw I was Tod";
		int len = palindrome.length();
		System.out.println(len);

		char[] tempCharArray = new char[len];
		char[] charArray = new char[len];

		// put original string in an array of chars
		// for(int i = 0; i<len; i++){
		// tempCharArray[i] = palindrome.charAt(i);
		// }

		palindrome.getChars(0, len, tempCharArray, 0);

		// reverse array of chars
		for (int j = 0; j < len; j++) {
			charArray[j] = tempCharArray[len - 1 - j];
		}

		String reversePalindrome = new String(charArray);
		System.out.println(palindrome);
		System.out.println(reversePalindrome);

		System.out.println("Hello ".concat("World."));
		System.out.println("Hello " + "World.");

		System.out.printf("The value of the float " + "variable is %.2f, while " + "the value of the "
				+ "integer variable is %d, " + "and the string is %s \n", 10.2, 10, "Hello World.");
		String fs = String.format("The value of the float " + "variable is %.2f, while " + "the value of the "
				+ "integer variable is %d, " + "and the string is %s", 10.2, 10, "Hello World.");
		System.out.println(fs);
	}

}
