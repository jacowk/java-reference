package za.co.reference.designpatterns.structuralpatterns.decorator;

public class VerticalScrollBarDecorator extends WindowDecorator{

	public VerticalScrollBarDecorator(Window decoratedWindow) {
		super(decoratedWindow);
	}

	@Override
	public void draw(){
		drawVerticalScrollBar();
		decoratedWindow.draw();
	}
	
	private void drawVerticalScrollBar(){
		System.out.println("Drawing Vertical Scrollbar");
	}

	@Override
	public String getDescription(){
		return decoratedWindow.getDescription() + ", including vertical scrollbars";
	}

}
