package za.co.reference.log4j.moreexamples.apractice;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog{
	
	public static void main(String[] args){
		TestLog testLog = new TestLog();
		testLog.configure();
		testLog.logTest();
	}
	
	private void configure(){
		PropertyConfigurator.configure("C:\\log4j.properties");
	}
	
	private void logTest(){
		log.debug("Debug message");
		log.info("Info message");
		log.warn("Warn message");
		log.error("Error message");
		log.fatal("Fatal error");
	}
	
	private Logger log = Logger.getLogger(TestLog.class);

}
