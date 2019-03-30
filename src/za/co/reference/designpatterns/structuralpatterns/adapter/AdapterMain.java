package za.co.reference.designpatterns.structuralpatterns.adapter;

public class AdapterMain{
	
	public static void main(String[] args){
		Shape line = new Line();
		Shape square = new Square();
		Shape circle = new CircleAdapter(new AnotherCircle());
		line.display();
		square.display();
		circle.display();
	}

}
