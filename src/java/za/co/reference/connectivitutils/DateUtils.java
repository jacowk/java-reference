package za.co.reference.connectivitutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils{

	private Date getDateFromString(String date, String format){
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    	Date formattedDate = null;
    	try{
    		formattedDate = formatter.parse(date);
    	}
    	catch (ParseException pe){
    		pe.printStackTrace();
    	}
    	return formattedDate;
    }
    
    private String getStringFromDate(Date date, String format){
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    	String formattedDate = null;
    	formattedDate = formatter.format(date);
    	return formattedDate;
    }
	
}