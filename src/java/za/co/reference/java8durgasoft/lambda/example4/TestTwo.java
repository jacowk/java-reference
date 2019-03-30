package za.co.reference.java8durgasoft.lambda.example4;

import za.co.reference.java8durgasoft.functionalinterfaces.example4.Interf;

public class TestTwo {

	int x = 10;
	
	public void m2()
	{
		int y = 20;
		Interf i = () -> {
			System.out.println(x);
			System.out.println(y);
		};
		i.m1();
	}
	
	public static void main(String[] args) {
		TestTwo testTwo = new TestTwo();
		testTwo.m2();
	}
	
}
