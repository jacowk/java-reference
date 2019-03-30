package za.co.reference.java8.optionalclass;

import java.util.Optional;

public class OptionalIsPresent {

	public static void main(String[] args) {
		Integer value1 = null;
		Integer value2 = new Integer(10);
		Optional<Integer> a = Optional.ofNullable(value1);
		Optional<Integer> b = Optional.of(value2);
		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());
	}
	
}
