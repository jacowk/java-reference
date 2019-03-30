package za.co.reference.utility;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtilities{

	public static Date getDate(String value, String dateFormat){
		Date formattedDate = null;
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		try{
			formattedDate = dateFormatter.parse(value);
		}
		catch (ParseException pe){
			pe.printStackTrace();
		}
		return formattedDate;
	}

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

	public static Date getCurrentDateFormattedReturnDate(String dateFormat){
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		Date formattedDate = null;
		try{
			formattedDate = dateFormatter.parse(dateFormatter.format(new Date()));
		}
		catch (ParseException pe){
			pe.printStackTrace();
		}
		return formattedDate;
	}

	public static String getCurrentDateFormattedReturnString(String dateFormat){
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		String formattedDate = dateFormatter.format(new Date());
		return formattedDate;
	}

	public static Date getEarliestTimeOfDayReturnDate(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	public static Date getLatestTimeOfDayReturnDate(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	public static String formatDate(String value, String format){
		Format formatter = new SimpleDateFormat(format);
		return formatter.format(value);
	}

	public static Date parseDate(String value, String format){
		DateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try{
			date = formatter.parse(value);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return date;
	}

	public static String formatDateForLocale(String value, String format, Locale locale){
		Format formatter = new SimpleDateFormat(format, locale);
		return formatter.format(value);
	}

	public static Date parseDateForLocale(String value, String format, Locale locale){
		DateFormat formatter = new SimpleDateFormat(format, locale);
		Date date = null;
		try{
			date = formatter.parse(value);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return date;
	}

	/*
	 * DateFormat.SHORT/MEDIUM/LONG/FULL/DEFAULT
	 */
	public static String formatTimeForLocaleDefaultFormat(String value, String format, Locale locale){
		return DateFormat.getTimeInstance(DateFormat.MEDIUM, locale).format(value);
	}

	public static Date parseTimeForLocaleDefaultFormat(String value, String format, Locale locale){
		Date date = null;
		try{
			date = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale).parse(value);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return date;
	}

	public static String formatDateForLocaleDefaultFormat(String value, String format, Locale locale){
		return DateFormat.getDateInstance(DateFormat.MEDIUM, locale).format(value);
	}

	public static Date parseDateForLocaleDefaultFormat(String value, String format, Locale locale){
		Date date = null;
		try{
			date = DateFormat.getDateInstance(DateFormat.MEDIUM, locale).parse(value);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return date;
	}

	public Date convertCalendarToDate(Calendar calendar){
		return calendar.getTime();
	}
	
	public Calendar convertDateToCalendar(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public Calendar addDaysToCurrentDate(int noOfDays){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, noOfDays);
		return calendar;
	}
	
	public Calendar addMonthsToCurrentDate(int noOfDays){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, noOfDays);
		return calendar;
	}
	
	public Calendar addYearsToCurrentDate(int noOfDays){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, noOfDays);
		return calendar;
	}
	
	private static void oneDate(){
		Date effectiveDate = getDate("2009/10/30", "yyyy/MM/dd");
		System.out.println("From Date: " + getEarliestTimeOfDayReturnDate(effectiveDate).getTime());
		System.out.println("To Date: " + getLatestTimeOfDayReturnDate(effectiveDate).getTime());
	}

	public static void main(String[] args){
//		System.out.println("formatGivenStringDateReturnString = " +
//			DateUtilities.formatGivenStringDateReturnString("20090101", "yyyyMMdd", "yyyy-MM-dd"));
		oneDate();
	}

	/*
	 * format parameter values:
	 * 		G  	Era designator 	Text  	AD
			y 	Year 	Year 	1996; 96
			M 	Month in year 	Month 	July; Jul; 07
			w 	Week in year 	Number 	27
			W 	Week in month 	Number 	2
			D 	Day in year 	Number 	189
			d 	Day in month 	Number 	10
			F 	Day of week in month 	Number 	2
			E 	Day in week 	Text 	Tuesday; Tue
			a 	Am/pm marker 	Text 	PM
			H 	Hour in day (0-23) 	Number 	0
			k 	Hour in day (1-24) 	Number 	24
			K 	Hour in am/pm (0-11) 	Number 	0
			h 	Hour in am/pm (1-12) 	Number 	12
			m 	Minute in hour 	Number 	30
			s 	Second in minute 	Number 	55
			S 	Millisecond 	Number 	978
			z 	Time zone 	General time zone 	Pacific Standard Time; PST; GMT-08:00
			Z 	Time zone 	RFC 822 time zone 	-0800
	 */
	public static String extractValueFromDate(Date date, String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String extractedValue = simpleDateFormat.format(date);
		return extractedValue;
	}

}
