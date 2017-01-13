package generics;

public class NatureNumber<T extends Integer> {
	private T n;

	public boolean isEven() {
		return n.intValue() % 2 == 0;
	}
	
	
}
