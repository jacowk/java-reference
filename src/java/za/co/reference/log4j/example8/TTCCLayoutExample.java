package za.co.reference.log4j.example8;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.TTCCLayout;

/*
 * In this part of Log4j tutorial we are going to discuss about the TTCCLayout which is extending DateLayout. It is another layout format for representing log events output.
 * 
 * It consists of following in its output log event: 
 * 
 * time 
 * thread 
 * category (Level) 
 * nested diagnostic context information 
 * name (output message) 
 * For example in our output as "16 [main] INFO TTCCLayoutExample.class - First Log".
 * 
 * Note : One of the most important thing while using TTCCLayout is that "You should not use same TTCCLayout instance from the different appenders because it is not fully thread safe.
 * 
 */
public class TTCCLayoutExample{
	
	public static void main(String[] args){
		try{
			FileAppender fileAppender = new FileAppender(new TTCCLayout(), "C:\\output.txt");
			logger.addAppender(fileAppender);
			logger.info("Hello world");
			logger.error("TTCCLayout example");
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private static Logger logger = Logger.getLogger("TTCCLayoutExample.class");

}
