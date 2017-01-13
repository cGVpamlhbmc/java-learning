package generics;

public class OrderedPair<K, V> implements Pair {

	private K k;
	private V v;

	public OrderedPair(K k, V v) {
		this.k = k;
		this.v = v;
	}

	@Override
	public Object getKey() {
		return this.k;
	}

	@Override
	public Object getValue() {
		return this.v;
	}

	public static void main(String[] args){
		OrderedPair<String,Integer> p1  =new OrderedPair<>("Hello", 100);
		System.out.println(p1.k);
		System.out.println(p1.v);
		
		GBox<Integer> box = new GBox();
	}
	
}
