package za.co.reference.designpatterns.creationalpatterns.factorymethod;

public class HamAndMushroomPizza implements Pizza{

	@Override
	public double getPrice(){
		return price;
	}
	
	private double price = 6.0;

}
