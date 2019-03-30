package za.co.reference.designpatterns.structuralpatterns.decorator;

public abstract class WindowDecorator implements Window{
	
	public WindowDecorator(Window decoratedWindow){
		this.decoratedWindow = decoratedWindow;
	}
	
	protected Window decoratedWindow;

}
