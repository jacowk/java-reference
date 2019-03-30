package za.co.reference.log4j.example3;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/*
 * Example of a FileAppender
 * 
 * I noticed that a Configurator is not necessary for this (BasicConfigurator/PropertyConfigurator),
 * unless the FileAppender is specified in a properties file
 * 
 */
public class FileAppenderExample{
	
	public static void main(String[] args){
		try{
			FileAppender fileAppender = new FileAppender(new PatternLayout(), "C:\\log4joutput.txt");
			logger.addAppender(fileAppender);
			logger.info("Test 1");
			logger.info("Test 2");
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private static Logger logger = Logger.getLogger("FileAppenderExample.class");

}
