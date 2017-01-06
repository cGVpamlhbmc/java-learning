package iandi;

public class Book {

	public Book(String isbn) {
		this.ISBN = isbn;
	}

	private String ISBN = "";

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String isbn) {
		this.ISBN = isbn;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			return ISBN.equals(((Book) obj).getISBN());
		} else {
			return false;
		}
	}

	public String toString() {
		return super.toString() + " , ISBN: " + this.ISBN;
	}

	static void printClass(Object obj) {
		System.out.println("The object's" + " class is " + obj.getClass().getSimpleName());
	}

	public static void main(String[] args) {
		String a = new String("abc");
		String b = new String("abc");
		System.out.println(a.equals(b));
		System.out.println("def".equals("def"));
		Book firstBook = new Book("0201914670");
		Book secondBook = new Book("0201914670");
		if (firstBook.equals(secondBook)) {
			System.out.println("objects are equal");
		} else {
			System.out.println("objects are not equal");
		}

		printClass(firstBook);
		System.out.println(firstBook.toString());
	}
}
