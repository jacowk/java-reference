package za.co.reference.java8.datetime.temporaladjusters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * TemporalAdjuster is used to perform the date mathematics. For example, get the "Second Saturday of the Month" or "Next Tuesday". 
 * 
 * @author jaco57
 *
 */
public class Java8Tester {

	public static void main(String[] args) {
		//Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("Current date: " + date1);
					
		//get the next tuesday
		LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("Next Tuesday on : " + nextTuesday);
					
		//get the second saturday of next month
//		LocalDate firstInYear = LocalDate.of(date1.getYear(),date1.getMonth(), 1);
//		LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		
		//get the second saturday of next month (Corrected)
		LocalDate nextMonth = date1.plusMonths(1);
		LocalDate firstOfNextMonth = LocalDate.of(nextMonth.getYear(), nextMonth.getMonth(), 1);
		LocalDate secondSaturday = firstOfNextMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday on : " + secondSaturday);
	}
	
}
