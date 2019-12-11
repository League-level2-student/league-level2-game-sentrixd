package game;

public class Button {
	int x, y, sizex, sizey;
	String methodName;
	
	
	Button(int x, int y, int sizex, int sizey, String methodName) {
		System.out.println("New button was created!");
		this.x = x;
		this.y = y;
		this.sizex = sizex;
		this.sizey = sizey;
		this.methodName = methodName;
	}
}
