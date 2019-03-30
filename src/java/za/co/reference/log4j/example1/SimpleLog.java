package za.co.reference.log4j.example1;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/*
 * 
 * Before starting with the examples, first read notes.txt
 * 
 * Example 1 shows the use of a BasicConfigurator to configure log4j
 * As an exercise, comment the following line out and checj the error you get.
 * "BasicConfigurator.configure();"
 *  
 */

public class SimpleLog{
	
	public static void main(String[] args){
		BasicConfigurator.configure();
		logger.debug("Hello world");
	}
	
	public static Logger logger = Logger.getLogger("SimpleLog.class");

}
