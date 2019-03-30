package za.co.reference.practice;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PracticeNumbers{
	
	public static String formatAmountValueGivenInRands(String amountValue, String format){
		/* format returns String, parse returns instance of Number */
		NumberFormat decimalFormat = new DecimalFormat(format);
		String formattedAmountValueString = decimalFormat.format(Double.parseDouble(amountValue));
		return formattedAmountValueString;
	}
	
	public static String formatAmountValueGivenInCents(String amountValue, String format){
		NumberFormat decimalFormat = new DecimalFormat(format);
		String formattedAmountValueString = decimalFormat.format(Double.parseDouble(amountValue) / 100);
		return formattedAmountValueString;
	}
	
	public static void main(String[] args){
		System.out.println(PracticeNumbers.formatAmountValueGivenInRands("123456789", "#,##0.00"));
		System.out.println(PracticeNumbers.formatAmountValueGivenInCents("123456789", "#,##0.00"));
	}

}
