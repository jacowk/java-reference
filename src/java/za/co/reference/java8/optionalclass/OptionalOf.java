package za.co.reference.java8.optionalclass;

import java.util.Optional;

public class OptionalOf {

	public static void main(String[] args) {
		Integer value2 = new Integer(10);
		Optional<Integer> b = Optional.of(value2); //throws NullPointer on next line if value2 is null
		System.out.println("Second parameter is present: " + b.isPresent());
	}
	
}
