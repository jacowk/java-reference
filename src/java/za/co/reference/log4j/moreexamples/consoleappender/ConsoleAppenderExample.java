package za.co.reference.log4j.moreexamples.consoleappender;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class ConsoleAppenderExample{
	
	public static void main(String[] args){
		Logger logger = Logger.getLogger("ConsoleAppenderExample.class");
		ConsoleAppender conappender = new ConsoleAppender(new PatternLayout());
		logger.debug("Content part 1");
		logger.debug("Content part 2");
		logger.debug("Content part 3");
		logger.addAppender(conappender);
	}

}
