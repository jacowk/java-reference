package za.co.reference.log4j.example7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.xml.XMLLayout;

/*
 * XMLLayout is used to produce logging output as XML
 * 
 */
public class XMLLayoutExample{
	
	public static void main(String[] args){
		try{
			FileOutputStream fileOutputStream = new FileOutputStream("C:\\xmloutout.xml");
			WriterAppender writerAppender = new WriterAppender(new XMLLayout(), fileOutputStream);
			logger.addAppender(writerAppender);
			logger.info("Hello world");
			logger.fatal("XMLLayout example");
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
	}
	
	private static Logger logger = Logger.getLogger("XMLLayoutExample.class"); 

}
