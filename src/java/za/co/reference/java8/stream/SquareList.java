package za.co.reference.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareList {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Numbers List: " + numbers);
		System.out.println("Squares List: " + squaresList);
	}
	
}
