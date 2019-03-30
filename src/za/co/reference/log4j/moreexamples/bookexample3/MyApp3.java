package za.co.reference.log4j.moreexamples.bookexample3;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyApp3{
	
	public static void main(String[] args){
		PropertyConfigurator.configure("src\\za\\co\\javastudent\\log4j\\bookexample3\\log4j.properties");
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warn message");
		logger.error("Error message");
		logger.fatal("Fatal message");
	}
	
	final static Logger logger = Logger.getLogger(MyApp3.class);


}