package za.co.reference.java8durgasoft.defaultmethods.inheritance;

public class Test implements Left, Right
{

	public void m1()
	{
		System.out.println("Test Class Method");
	}
	
	public void execute()
	{
		Left.super.m1();
		Right.super.m1();
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.m1();
		test.execute();
	}
	
}
