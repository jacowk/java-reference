package za.co.reference.designpatterns.structuralpatterns.decorator;

public class DecoratedWindowTest{
	
	public static void main(String[] args){
		Window decoratedWindow = new VerticalScrollBarDecorator(new SimpleWindow());
		System.out.println(decoratedWindow.getDescription());
		decoratedWindow.draw();
	}

}
