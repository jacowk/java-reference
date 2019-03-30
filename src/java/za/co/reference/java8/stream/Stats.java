package za.co.reference.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Stats {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
		System.out.println("List: " + integers);
		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest number in List: " + stats.getMax());
		System.out.println("Lowest number in List: " + stats.getMin());
		System.out.println("Sum of all numbers: " + stats.getSum());
		System.out.println("Average of all numbers: " + stats.getAverage());
		System.out.println("Count of all numbers: " + stats.getCount());
	}
	
}
