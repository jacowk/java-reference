package za.co.reference.designpatterns.creationalpatterns.abstractfactory;

public class WinFactory implements GUIFactory{

	@Override
	public Button createButton(){
		return new WinButton();
	}

}
