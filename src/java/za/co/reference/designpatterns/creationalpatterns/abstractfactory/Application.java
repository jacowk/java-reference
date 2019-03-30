package za.co.reference.designpatterns.creationalpatterns.abstractfactory;

public class Application{
	
	public Application(GUIFactory factory){
		Button button = (Button)factory.createButton();
		button.paint();
	}

}
