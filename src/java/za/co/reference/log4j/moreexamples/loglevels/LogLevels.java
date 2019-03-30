package za.co.reference.log4j.moreexamples.loglevels;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerRepository;

public class LogLevels{
	
	public static void main(String[] args){
		BasicConfigurator.configure();
		LoggerRepository repository = null;
		
		Logger comLogger = Logger.getLogger("com"); //Level 1
		repository = comLogger.getLoggerRepository();
		repository.setThreshold(Level.WARN); //Causes INFO and DEBUG levels to be disabled, even if the logger 
											//level is set to INFO
		comLogger.setLevel(Level.INFO);
		comLogger.debug("comLogger debug"); //Disabled
		comLogger.info("comLogger info"); //Enabled
		comLogger.warn("comLogger warn"); //Enabled
		comLogger.error("comLogger error"); //Enabled
		comLogger.fatal("comLogger fatal"); //Enabled
		
		Logger fooLogger = Logger.getLogger("com.foo"); //Level 2
		fooLogger.setLevel(Level.WARN);
		fooLogger.debug("fooLogger debug"); //Disabled
		fooLogger.info("fooLogger info"); //Disabled
		fooLogger.warn("fooLogger warn"); //Enabled
		fooLogger.error("fooLogger error"); //Enabled
		fooLogger.fatal("fooLogger fatal"); //Enabled
		
		Logger barLogger = Logger.getLogger("com.foo.bar"); //Level 3
		barLogger.setLevel(Level.ERROR);
		barLogger.debug("barLogger debug"); //Disabled
		barLogger.info("barLogger info"); //Disabled
		barLogger.warn("barLogger warn"); //Disabled
		barLogger.error("barLogger error"); //Enabled
		barLogger.fatal("barLogger fatal"); //Enabled
		
		Logger booLogger = Logger.getLogger("com.boo"); //Level 2: Inherit it's level also from "com"
		booLogger.debug("fooLogger debug"); //Disabled
		booLogger.info("fooLogger info"); //Enabled
		booLogger.warn("fooLogger warn"); //Enabled
		booLogger.error("fooLogger error"); //Enabled
		booLogger.fatal("fooLogger fatal"); //Enabled
	}

}
