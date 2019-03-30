package za.co.reference.java8.optionalclass;

import java.util.Optional;

public class OptionalOrElse {

	public static void main(String[] args) {
		Integer value1 = null;
		Optional<Integer> a = Optional.ofNullable(value1);
		Integer value2 = a.orElse(new Integer(0));
		System.out.println("value1 = " + value1);
		System.out.println("value2 = " + value2);
	}
	
}
