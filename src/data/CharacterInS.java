/**
 * 
 */
package data;

/**
 * @author ypj6024
 *
 */
public class CharacterInS {
	public static void main(String[] args) {
		String anotherPalindrome = "Niagara. O roar again!";
		char aChar = anotherPalindrome.charAt(9);
		String roar = anotherPalindrome.substring(11, 15);

		String[] s1 = anotherPalindrome.split("a");
		String[] s2 = anotherPalindrome.split("a", 3);
		// anotherPalindrome.subSequence()
		System.out.println(roar);
		System.out.println(anotherPalindrome.toLowerCase());
		System.out.println(anotherPalindrome.toUpperCase());

		final String FPATH = "/home/user/index.html";
		Filename myHomePage = new Filename(FPATH, '/', '.');
		System.out.println("Extension = " + myHomePage.extension());
		System.out.println("Filename = " + myHomePage.filename());
		System.out.println("Path = " + myHomePage.path());

	}
}
