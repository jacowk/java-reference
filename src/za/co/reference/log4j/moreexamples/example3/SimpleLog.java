package za.co.reference.log4j.moreexamples.example3;

import org.apache.log4j.*;
import org.apache.log4j.BasicConfigurator;
public class SimpleLog {
	static Logger logger = Logger.getLogger("SimpleLog.class");
	public static void main(String[] args) {
		BasicConfigurator.configure();
		logger.debug("Hello world.");	
		}
}