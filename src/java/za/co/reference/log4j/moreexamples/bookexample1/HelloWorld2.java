package za.co.reference.log4j.moreexamples.bookexample1;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HelloWorld2{
	
	public static void main(String[] args){
		BasicConfigurator.configure();
		logger.debug("Hello World");
	}
	
	static Logger logger = Logger.getLogger("za.co.javastudent.log4j.bookexample1.HelloWorld2"); 
		//The string parameter should be the fully qualified name of your class
	
	

}
