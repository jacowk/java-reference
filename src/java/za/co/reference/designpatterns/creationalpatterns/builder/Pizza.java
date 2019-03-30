package za.co.reference.designpatterns.creationalpatterns.builder;

/*
 * Product
 */
public class Pizza{
	
	public String getDough(){
		return dough;
	}
	
	public void setDough(String dough){
		this.dough = dough;
	}
	
	public String getSauce(){
		return sauce;
	}
	
	public void setSauce(String sauce){
		this.sauce = sauce;
	}
	
	public String getTopping(){
		return topping;
	}
	
	public void setTopping(String topping){
		this.topping = topping;
	}
	
	private String dough = "";
	private String sauce = "";
	private String topping = "";

}
