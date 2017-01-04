package iandi;

public class Subclass extends Superclass{
	
	public Subclass(){}
	
	public Subclass(String param1, String param2){
		super(param1);
		//do something other
	}
	
	// overrides printMethod in Superclass
    public void printMethod() {
        super.printMethod();
        System.out.println("Printed in Subclass");
    }
    public static void main(String[] args) {
        Subclass s = new Subclass();
        s.printMethod();    
    }
}
