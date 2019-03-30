package za.co.reference.java8.defaultmethods;

public interface Vehicle {

	public void nonDefaultMethod();
	
	public default void print()
	{
		System.out.println("This is the default method for the Vehicle interface");
	}
	
}
