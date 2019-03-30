package za.co.reference.java8.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Functional Interfaces:
 * Functional interfaces have a single functionality to exhibit. For example, a Comparable interface with a single method ‘compareTo’ 
 * is used for comparison purpose. Java 8 has defined a lot of functional interfaces to be used extensively in lambda expressions.
 * 
 * @author Jaco Koekemoer
 * Date: 2017-06-15
 *
 */
public class Java8Tester {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		// Predicate<Integer> predicate = n -> true;
		// n is passed as parameter to test method of Predicate interface
		// test method will always return true no matter what value n has
		System.out.println("Print numbers:");
		
		//pass n as parameter
//		eval(list, n -> true);
		eval(list, n -> n > 5);
		
	}
	
	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n: list) {
			if (predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
	}
	
}
