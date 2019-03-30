package za.co.reference.java8durgasoft.lambda.example4;

import za.co.reference.java8durgasoft.functionalinterfaces.example4.Interf;

public class TestOne {

	int x = 777;
	
	public void m2()
	{
		Interf i = () -> {
			int x = 888;
			System.out.println(x);
			System.out.println(this.x);
		};
		i.m1();
	}
	
	public static void main(String[] args)
	{
		TestOne test = new TestOne();
		test.m2();
	}
	
}
