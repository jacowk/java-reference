package za.co.reference.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListToString {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "jkl");
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
	}
	
}
