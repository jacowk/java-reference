package za.co.reference.designpatterns.creationalpatterns.builder;

public class BuilderExample{
	
	public static void main(String[] args){
		Cook cook = new Cook();
		PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
		cook.setPizzaBuilder(hawaiianPizzaBuilder);
		cook.constructPizza();
		Pizza pizza = cook.getPizza();
	}

}
