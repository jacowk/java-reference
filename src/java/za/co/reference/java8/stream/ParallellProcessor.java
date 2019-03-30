package za.co.reference.java8.stream;

import java.util.Arrays;
import java.util.List;

public class ParallellProcessor {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "jkl");
		long count = strings.parallelStream().filter(string -> !string.isEmpty()).count();
		System.out.println("Count: " + count);
	}
	
}
