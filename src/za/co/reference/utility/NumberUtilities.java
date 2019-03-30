package za.co.reference.utility;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtilities{
	
	/**  Example documentation
	 * Formats a given date according to the specified format string.  The date must conform to the
	 * current date format pattern.
	 *
	 * @param date the date to be formatted.
	 * @param newDateFormat the desired date format.
	 * @param currentDateFormat the current date format.
	 * @return String the formatted date string.
	 */
	
	public static String formatAmountValueGivenInCents(String amountValue, String format){
		DecimalFormat decimalFormat = new DecimalFormat(format);
		StringBuffer stringBuffer = new StringBuffer(amountValue);
		String formattedAmountValueString = decimalFormat.format(Double.parseDouble(stringBuffer.toString()) / 100);
		return formattedAmountValueString;
	}
	
	public static String formatAmountValueGivenInRands(String amountValue, String format){
		DecimalFormat decimalFormat = new DecimalFormat(format);
		StringBuffer stringBuffer = new StringBuffer(amountValue);
		String formattedAmountValueString = decimalFormat.format(Double.parseDouble(stringBuffer.toString()));
		return formattedAmountValueString;
	}
	
	public static String formatNumber(String value, String format){
		NumberFormat formatter = new DecimalFormat(format);
		return formatter.format(value);
	}
	
	/*
	 * Locale example = Locale.CANADA
	 */
	public static String formatNumberForLocale(String value, Locale locale){
		return NumberFormat.getNumberInstance(locale).format(value);
	}
	
	public static String formatNumberForDefaultLocale(String value){
		return NumberFormat.getNumberInstance().format(value);
	}
	
	public static Number parseStringForLocale(String value, Locale locale){
		Number number = null;
		try{
			number = NumberFormat.getNumberInstance(locale).parse(value);
		}
		catch (Exception pe){
			pe.printStackTrace();
		}
		return number;
	}
	
	public static String formatLocaleSpecificCurrency(String value, Locale locale){
		return NumberFormat.getCurrencyInstance(locale).format(value);
	}
	
	public static Number parseLocaleSpecificCurrency(String value, Locale locale){
		Number number = null;
		try{
			number = NumberFormat.getCurrencyInstance(locale).parse(value);
		}
		catch (Exception pe){
			pe.printStackTrace();
		}
		return number;
	}
	
	public static String formatLocaleSpecificPercentage(String value, Locale locale){
		return NumberFormat.getPercentInstance(locale).format(value);
	}
	
	public static Number parseLocaleSpecificPercentage(String value, Locale locale){
		Number number = null;
		try{
			number = NumberFormat.getPercentInstance(locale).parse(value);
		}
		catch (Exception pe){
			pe.printStackTrace();
		}
		return number;
	}
	
	public static void main(String[] args){
		System.out.println("formatAmountValueGivenInCents: " + NumberUtilities.formatAmountValueGivenInCents("457823", "#,##0.00"));
		System.out.println("formatAmountValueGivenInRands: " + NumberUtilities.formatAmountValueGivenInRands("4578", "#,##0.00"));
	}

}
