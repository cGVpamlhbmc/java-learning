package generics;

public class GBox<T> {
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return this.t;
	}

	public <U extends String> void inspect(U u) {
		System.out.println("T: " + t.getClass().getName());
		System.out.println("U: " + u.getClass().getName());
	}
	
	public static void main(String[] args){
		GBox<Integer> integerBox = new GBox<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect("some text"); // error: this is still String!
	}
}
