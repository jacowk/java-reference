package za.co.reference.log4j.example2;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;

/*
 * Example 2 is a ConsoleAppender example.
 */

public class ConsoleAppenderExample{
	
	public static void main(String[] ags){
		ConsoleAppender consoleAppender = new ConsoleAppender();
		BasicConfigurator.configure();
		logger.debug("Log 1");
		logger.debug("Log 2");
		logger.debug("Log 3");
		logger.addAppender(consoleAppender);
	}
	
	private static Logger logger = Logger.getLogger("ConsoleAppenderExample.class");

}
