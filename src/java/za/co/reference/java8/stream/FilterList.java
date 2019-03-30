package za.co.reference.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterList {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "jkl");
		System.out.println("Unfiltered List: " + strings);
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered List: " + filtered);
	}
	
}
