package za.co.reference.designpatterns.creationalpatterns.abstractfactory;

public class WinButton implements Button{

	@Override
	public void paint(){
		System.out.println("The Windows Button");
	}

}
