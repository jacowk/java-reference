package za.co.reference.log4j.moreexamples.bookexample2;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyApp2{
	
	public static void main(String[] args){
		PropertyConfigurator.configure("src\\za\\co\\javastudent\\log4j\\bookexample2\\log4j.properties");
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warn message");
		logger.error("Error message");
		logger.fatal("Fatal message");
		
		Foo foo = new Foo();
		foo.doIt();
	}
	
	final static Logger logger = Logger.getLogger(MyApp2.class);


}

class Foo{
	
	public void doIt(){
		logger.debug("foo message");
	}
	
	static final Logger logger = Logger.getLogger(Foo.class);
	
}
