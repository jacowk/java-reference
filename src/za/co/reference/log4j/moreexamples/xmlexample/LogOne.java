package za.co.reference.log4j.moreexamples.xmlexample;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class LogOne{
	
	public static void main(String[] args){
		Logger logger = Logger.getLogger(LogOne.class);
		DOMConfigurator.configure("src\\za\\co\\javastudent\\log4j\\example1\\log4j.xml");
		logger.debug("Hello debug");
		logger.info("Hello info");
		logger.warn("Hello warn");
		logger.error("Hello error");
		logger.fatal("Hello fatal");
	}

}
