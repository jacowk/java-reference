package za.co.reference.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PracticeDates{
	
	public static String formatGivenStringDateReturnString(String date, String currentDateFormat, String newDateFormat){
		SimpleDateFormat dateFormatter = new SimpleDateFormat(currentDateFormat);
		String formattedDate = null;
		try{
			Date currentDate = dateFormatter.parse(date);
			dateFormatter.applyPattern(newDateFormat);
			formattedDate = dateFormatter.format(currentDate);
		}
		catch (ParseException pe){
			pe.printStackTrace();
		}
		return formattedDate;
	}
	
	public static Date formatGivenStringDateReturnDate(String date, String currentDateFormat, String newDateFormat){
		SimpleDateFormat dateFormatter = new SimpleDateFormat(currentDateFormat);
		Date formattedDate = null;
		try{
			Date currentDate = dateFormatter.parse(date);
			dateFormatter.applyPattern(newDateFormat);
			formattedDate = dateFormatter.parse(dateFormatter.format(currentDate));
		}
		catch (ParseException pe){
			pe.printStackTrace();
		}
		return formattedDate;
	}
	
	public static String formatGivenDateReturnString(Date date, String newDateFormat){
		SimpleDateFormat dateFormatter = new SimpleDateFormat(newDateFormat);
		String formattedDate = dateFormatter.format(date);
		return formattedDate;
	} 
	
	public static Date formatGivenDateReturnDate(Date date, String newDateFormat){
		SimpleDateFormat dateFormatter = new SimpleDateFormat(newDateFormat);
		Date formattedDate = null;
		try{
			formattedDate = dateFormatter.parse(dateFormatter.format(date));
		}
		catch (ParseException pe){
			pe.printStackTrace();
		}
		return formattedDate;
	}
	
//	public static Date getEarliestTimeToday(){
//		Calendar calendar = new GregorianCalendar();
//		calendar.setTimeInMillis(System.currentTimeMillis());
//		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
//		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
//		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
//		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
//		return calendar.getTime();
//	}
//	
//	public static Date getLatestTimeToday(){
//		Calendar calendar = new GregorianCalendar();
//		calendar.setTimeInMillis(System.currentTimeMillis());
//		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
//		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
//		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
//		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
//		return calendar.getTime();
//	}
	
	public static Date getEarliestTimeOfDay(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		return calendar.getTime();
	}
	
	public static Date getLatestTimeOfDay(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
		return calendar.getTime();
	}
	
	public static Date addNumberOfDays(Date date, int numberOfDays){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, numberOfDays);
		return calendar.getTime();
	}
	
	public static Date subtractNumberOfDays(Date date, int numberOfDays){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -numberOfDays);
		return calendar.getTime();
	}
	
	public static void main(String[] args){
		try{
			Date date = subtractNumberOfDays(new Date(), 2);
			System.out.println(date.toString());
		}
		catch (Exception pe){
			pe.printStackTrace();
		}
	}

}
