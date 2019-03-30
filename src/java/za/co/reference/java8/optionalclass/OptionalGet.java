package za.co.reference.java8.optionalclass;

import java.util.Optional;

public class OptionalGet {

	public static void main(String[] args) {
		Integer value2 = null;
		Optional<Integer> b = Optional.ofNullable(value2);
		
		Integer value4 = b.orElse(new Integer(5));
		System.out.println(value4);
	}
	
}
