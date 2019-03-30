package za.co.reference.designpatterns.structuralpatterns.adapter;

public class CircleAdapter implements Shape{
	
	public CircleAdapter(AnotherCircle anotherCircle){
		this.anotherCircle = anotherCircle;
	}
	
	@Override
	public void display(){
		anotherCircle.show();
	}
	
	private AnotherCircle anotherCircle;

}
