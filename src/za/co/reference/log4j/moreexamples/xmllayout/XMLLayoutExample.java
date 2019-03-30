package za.co.reference.log4j.moreexamples.xmllayout;

import java.io.*;
import org.apache.log4j.*;
import org.apache.log4j.xml.XMLLayout;

public class XMLLayoutExample {
  static Logger logger = 
  Logger.getLogger("XMLLayoutExample.class");
  public static void main(String[] args) {
    try{
      FileOutputStream filename=
      new FileOutputStream("XMLWriter.xml");
      WriterAppender writeappender = 
      new WriterAppender(new XMLLayout(),filename);
      logger.addAppender(writeappender);
      logger.info("Welcome");
      logger.info("to");
      logger.info("Rose India");
      logger.info("Writer Appender");
      logger.info("Example");
      logger.info("-----------");
    }catch(Exception e){
    System.out.println("Exception is ="+e.getMessage()); 
    }
  }
}