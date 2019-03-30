package za.co.reference.designpatterns.creationalpatterns.builder;

/*
 * Cook
 */
public class Cook{
	
	private PizzaBuilder pizzaBuilder;
	
	public void setPizzaBuilder(PizzaBuilder pb){
		pizzaBuilder = pb;
	}
	
	public Pizza getPizza(){
		return pizzaBuilder.getPizza();
	}
	
	public void constructPizza(){
		pizzaBuilder.createNewPizzaProduct();
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSauce();
		pizzaBuilder.buildTopping();
	}
	
}
