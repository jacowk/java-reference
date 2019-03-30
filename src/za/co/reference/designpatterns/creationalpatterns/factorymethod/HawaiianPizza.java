package za.co.reference.designpatterns.creationalpatterns.factorymethod;

public class HawaiianPizza implements Pizza{

	@Override
	public double getPrice(){
		return price;
	}
	
	private double price = 7.0;

}
