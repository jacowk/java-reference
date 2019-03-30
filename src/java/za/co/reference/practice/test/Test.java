package za.co.reference.practice.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test{
	
	public static void main(String[] args) throws Exception{
		String date = "2010-11-11";
		String format = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date dateAsDate = formatter.parse(date);
		Calendar currentDate = Calendar.getInstance();
		currentDate.setTime(dateAsDate);
		currentDate.add(Calendar.DAY_OF_MONTH, 2);
		System.out.println("Date: " + formatter.format(currentDate.getTime()));
		currentDate.add(Calendar.DAY_OF_MONTH, -5);
		System.out.println("Date: " + formatter.format(currentDate.getTime()));
	}

}
