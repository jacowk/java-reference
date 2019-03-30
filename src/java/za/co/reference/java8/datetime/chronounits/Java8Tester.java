package za.co.reference.java8.datetime.chronounits;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author Jaco Koekemoer
 * 
 * Things to know:
 * 
 * Create a local date for now
 * Add 1 week
 * Add 1 month
 * Add 1 year
 * Add 1 decade
 *
 */
public class Java8Tester {

	public static void main(String[] args) {
		//Get the current date
		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);
					
		//add 1 week to the current date
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next week: " + nextWeek);
					
		//add 1 month to the current date
		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + nextMonth);
					
		//add 1 year to the current date
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next year: " + nextYear);
					
		//add 10 years to the current date
		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("Date after ten year: " + nextDecade);
	}
	
}
