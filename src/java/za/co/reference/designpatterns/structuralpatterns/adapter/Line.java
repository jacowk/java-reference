package za.co.reference.designpatterns.structuralpatterns.adapter;

public class Line implements Shape{

	@Override
	public void display(){
		System.out.println("This is a line");
	}

}
