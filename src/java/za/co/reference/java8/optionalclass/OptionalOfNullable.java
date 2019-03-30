package za.co.reference.java8.optionalclass;

import java.util.Optional;

public class OptionalOfNullable {

	public static void main(String[] args) {
		Integer value1 = null;
		Optional<Integer> a = Optional.ofNullable(value1); //Allows passed parameter to be null
		System.out.println("First parameter is present: " + a.isPresent());
	}
	
}
