package za.co.reference.log4j.example6;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class SimpleLayoutExample{
	
	public static void main(String[] args){
		try{
			FileAppender fileAppender = new FileAppender(new SimpleLayout(), "C:\\output.txt");
			logger.addAppender(fileAppender);
			logger.info("Hello world");
			logger.debug("SimpleLayout example");
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private static Logger logger = Logger.getLogger("SimpleLayoutExample.class");

}
