package za.co.reference.log4j.example4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;

/*
 * Example 3 demonstrates a WriterAppender
 * WriterAppender appends log events to a Writer or an OutputStream depending on the user's choice.
 * A Configurator is not necessary, because we don't use a configuration file
 */

public class WriterAppenderExample {

	public static void main(String[] args){
		try{
			FileOutputStream fileOutputStream = new FileOutputStream("C:\\writer.html");
			WriterAppender writerAppender = new WriterAppender(new HTMLLayout(), fileOutputStream);
			logger.addAppender(writerAppender);
			logger.info("Hello world");
			logger.info("This is an example of ");
			logger.info("A WriterAppender");
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
	}
	
	private static Logger logger = Logger.getLogger("WriterAppenderExample.class");
	
}
