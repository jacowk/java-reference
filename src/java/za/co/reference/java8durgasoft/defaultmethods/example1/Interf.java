package za.co.reference.java8durgasoft.defaultmethods.example1;

public interface Interf {

	public default void m1()
	{
		System.out.println("Default method");
	}
	
	public default int getNumber()
	{
		return 10;
	}
	
}
