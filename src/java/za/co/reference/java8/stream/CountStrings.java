package za.co.reference.java8.stream;

import java.util.Arrays;
import java.util.List;

public class CountStrings {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "de", "", "ghi", "", "jkl");
		long count = strings.stream().filter(string -> string.length() == 3).count();
		System.out.println("Strings of length 3: " + count);
	}
	
}
