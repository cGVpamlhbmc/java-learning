package iandi;

public abstract class GraphicObject {
	int x, y;
	
	void moveTo(int x, int y){
		//...
	}
	
	abstract void draw();
	
	abstract void resize();
}
