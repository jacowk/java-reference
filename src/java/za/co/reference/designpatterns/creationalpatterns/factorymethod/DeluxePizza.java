package za.co.reference.designpatterns.creationalpatterns.factorymethod;

public class DeluxePizza implements Pizza{

	@Override
	public double getPrice(){
		return price;
	}
	
	private double price = 8.0;

}
