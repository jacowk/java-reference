package za.co.reference.java8.stream;

import java.util.Arrays;
import java.util.List;

public class CountEmptyFilter {
	
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "jkl");
		System.out.println(strings);
		
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);
	}

}
