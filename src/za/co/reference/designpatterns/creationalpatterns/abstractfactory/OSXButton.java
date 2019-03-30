package za.co.reference.designpatterns.creationalpatterns.abstractfactory;

public class OSXButton implements Button{

	@Override
	public void paint(){
		System.out.println("The OSX Button");
	}

}
