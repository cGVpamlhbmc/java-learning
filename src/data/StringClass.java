/**
 * 
 */
package data;

/**
 * @author ypj6024
 *
 */
public class StringClass {
	
	public static void main(String[] args){
		String greeting = "Hello World.";
		System.out.println(greeting);
		
		char[] helloArray = {'h','e','l','l','o'};
		String helloString = new String(helloArray);
		System.out.println(helloString);
		
		String palindrome = "Dot saw I was Tod";
		System.out.println(palindrome.length());
	}

}
