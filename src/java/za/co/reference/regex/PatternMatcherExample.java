package za.co.reference.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherExample{
	
	public static void main(String[] args){
		Pattern pattern = Pattern.compile(".gz$");
    	Matcher matcher = pattern.matcher("test.gz");
    	System.out.println(matcher.find());
	}

}