package za.co.reference.log4j.moreexamples.bookexample5;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class BookPlay{
	
	public static void main(String[] args){
		DOMConfigurator.configure("src\\za\\co\\javastudent\\log4j\\bookexample5\\log4j.xml");
		
		System.out.println("===============================");
		System.out.println("LOGGER ONE");
		System.out.println("===============================");
		Logger logOne = Logger.getLogger("com");
		logOne.debug("Debug log 1");
		logOne.info("Info log 1");
		logOne.warn("Warn log 1");
		logOne.error("Error log 1");
		logOne.fatal("Fatal log 1");
		
		System.out.println("===============================");
		System.out.println("LOGGER TWO");
		System.out.println("===============================");
		Logger logTwo = Logger.getLogger("com.foo");
		logTwo.debug("Debug log 2");
		logTwo.info("Info log 2");
		logTwo.warn("Warn log 2");
		logTwo.error("Error log 2");
		logTwo.fatal("Fatal log 2");
		
		System.out.println("===============================");
		System.out.println("LOGGER THREE");
		System.out.println("===============================");
		Logger logThree = Logger.getLogger("com.foo.bar");
		logThree.debug("Debug log 3");
		logThree.info("Info log 3");
		logThree.warn("Warn log 3");
		logThree.error("Error log 3");
		logThree.fatal("Fatal log 3");
	}

}
