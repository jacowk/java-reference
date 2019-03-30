package za.co.reference.log4j.moreexamples.example1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogExample{
	
	public LogExample(){
		
	}
	
	public static void main(String[] args){
		PropertyConfigurator.configure("src\\za\\co\\javastudent\\log4j\\example1\\log4j.properties");
		log.debug("Here is some DEBUG");
        log.info("Here is some INFO");
        log.warn("Here is some WARN");
        log.error("Here is some ERROR");
        log.fatal("Here is some FATAL");
	}
	
	private static Logger log = Logger.getLogger(LogExample.class);

}
