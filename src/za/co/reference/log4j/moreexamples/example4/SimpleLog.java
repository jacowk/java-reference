package za.co.reference.log4j.moreexamples.example4;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class SimpleLog {
	static Logger logger = Logger.getLogger("SimpleLog.class");
	public static void main(String[] args) {
		DOMConfigurator.configure("src\\za\\co\\javastudent\\log4j\\example4\\log4j.xml");
		logger.debug("Welcome to Log4j");	
		}
}