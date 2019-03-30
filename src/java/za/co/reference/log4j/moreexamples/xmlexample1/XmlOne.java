package za.co.reference.log4j.moreexamples.xmlexample1;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class XmlOne{
	
	public static void main(String[] args){
		DOMConfigurator.configure("src\\za\\co\\javastudent\\log4j\\xmlexample1\\log4jrollingfileappender.xml");
		
		Logger comLogger = Logger.getLogger("com");
		comLogger.debug("comLogger debug");
		comLogger.info("comLogger info");
		comLogger.warn("comLogger warn");
		comLogger.error("comLogger error");
		comLogger.fatal("comLogger fatal");
		System.out.println("");
		
		Logger fooLogger = Logger.getLogger("com.foo");
		fooLogger.debug("fooLogger debug");
		fooLogger.info("fooLogger info");
		fooLogger.warn("fooLogger warn");
		fooLogger.error("fooLogger error");
		fooLogger.fatal("fooLogger fatal");
		System.out.println("");
		
		Logger barLogger = Logger.getLogger("com.foo.bar");
		barLogger.debug("barLogger debug");
		barLogger.info("barLogger info");
		barLogger.warn("barLogger warn");
		barLogger.error("barLogger error");
		barLogger.fatal("barLogger fatal");
		System.out.println("");
		
		Logger booLogger = Logger.getLogger("com.boo");
		booLogger.debug("booLogger debug");
		booLogger.info("booLogger info");
		booLogger.warn("booLogger warn");
		booLogger.error("booLogger error");
		booLogger.fatal("booLogger fatal");
		System.out.println("");
	}

}
