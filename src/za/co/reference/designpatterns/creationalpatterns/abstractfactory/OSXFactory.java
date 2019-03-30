package za.co.reference.designpatterns.creationalpatterns.abstractfactory;

public class OSXFactory implements GUIFactory{

	@Override
	public Button createButton(){
		return new OSXButton();
	}

}
