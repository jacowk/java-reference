package za.co.reference.log4j.example5;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/*
 * Conversion characters used for formatting:
 * %c Used to output the category of logging event 
 * %C Used to output the fully qualified class name of the caller issuing the logging request 
 * %d Used to output date of the logging event 
 * %m Used to output the application supplied message associated with the logging event 
 * %n Outputs the platform dependent line separator character or characters 
 * %p Used to output the priority of the logging event 
 * %r Used to output the number of milliseconds elapsed from the construction of the layout until the creation of the logging event 
 * %t Used to output name of thread of logging event 
 * %F Used to output the file name 
 * 
 */

public class PatternLayoutExample {

	public static void main(String[] args){
		try{
			PatternLayout patternLayout = new PatternLayout("%r [%t] %-5p %c %x - %m%n");
			FileAppender fileAppender = new FileAppender(patternLayout, "C:\\output.txt");
			logger.addAppender(fileAppender);
			logger.info("Hello world");
			logger.debug("PatternLayout example");
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private static Logger logger = Logger.getLogger("PatternLayoutExample.class");
	
}
