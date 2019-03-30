package za.co.reference.java8.test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Java8Tester
{
	
	public static void main(String[] args)
	{
		List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
		System.out.println(integers);
		
		IntSummaryStatistics stats = integers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println(stats.getAverage());
		System.out.println(stats.getCount());
		System.out.println(stats.getSum());
		System.out.println(stats.getMin());
		System.out.println(stats.getMax());
	}
	
}
