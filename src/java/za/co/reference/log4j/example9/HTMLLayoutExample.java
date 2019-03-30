package za.co.reference.log4j.example9;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Logger;

public class HTMLLayoutExample{
	
	public static void main(String[] args){
		try{
			FileAppender fileAppender = new FileAppender(new HTMLLayout(), "C:\\output.html");
			logger.addAppender(fileAppender);
			logger.info("Hello world");
			logger.error("HTMLLayout example");
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private static Logger logger = Logger.getLogger("HTMLLayoutExample.class");

}
