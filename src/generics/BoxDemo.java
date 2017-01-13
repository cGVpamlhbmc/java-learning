package generics;

public class BoxDemo {
	public static <U> void addBox(U u, java.util.List<GBox<U>> boxs) {
		GBox<U> box = new GBox<>();
		box.set(u);
		boxs.add(box);
	}

	public static <U> void outputBoxes(java.util.List<GBox<U>> boxs) {
		int counter = 0;
		for (GBox<U> box : boxs) {
			counter++;
			System.out.println("Box #" + counter + " contains [" + box.toString() + "]");
		}
	}

	public static void main(String[] args) {
		java.util.ArrayList<GBox<Integer>> listOfIntegerBoxes = new java.util.ArrayList<>();
		BoxDemo.<Integer> addBox(Integer.valueOf(10), listOfIntegerBoxes);
		BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
		BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
		BoxDemo.outputBoxes(listOfIntegerBoxes);
	}
}
