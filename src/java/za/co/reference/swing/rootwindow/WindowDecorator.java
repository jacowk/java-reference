package za.co.reference.swing.rootwindow;


public abstract class WindowDecorator implements Window{
	
	public WindowDecorator(Window decoratedWindow){
		this.decoratedWindow = decoratedWindow;
	}
	
	protected Window decoratedWindow;

}
