package za.co.reference.java8.datetime.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * 
 * @author Jaco Koekemoer
 * 
 * Things to know:
 * Output LocalDateTime
 * Convert LocalDateTime to LocalDate
 * Convert LocalDateTime to LocalTime
 * Get the day of month, month and year
 * Create local date time with a specified year, month, day of month
 * Create a local date with specific date
 * Create a local time with specific time
 * 
 * Next: Chrono units
 * Create a local date for now
 * Add 1 week
 * Add 1 month
 * Add 1 year
 * Add 1 decade
 * 
 * Next: Temporal Adjusters
 * Create a local date for now
 * Get next week Tuesday
 * Get the second Saturday of next month
 * 
 * Next: Period and Duration
 * 
 * Next: Backward compatibility
 *
 */
public class Java8Tester {

	public static void main(String[] args) {
		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);
		
		//Convert to LocalDate
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);
		
		//Get individual date elements
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();
					
		System.out.println("Month: " + month +"day: " + day +"seconds: " + seconds);
					
		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);
					
		//12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3);
					
		//22 hour 15 minutes
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);
					
		//parse a string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);
	}
	
}
