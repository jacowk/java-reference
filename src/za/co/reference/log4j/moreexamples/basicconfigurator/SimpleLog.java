package za.co.reference.log4j.moreexamples.basicconfigurator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class SimpleLog{
	
	public static void main(String[] args){
		BasicConfigurator.configure();
		logger.debug("Hello world.");  
	}
	
	static Logger logger = Logger.getLogger("SimpleLog.class");

}