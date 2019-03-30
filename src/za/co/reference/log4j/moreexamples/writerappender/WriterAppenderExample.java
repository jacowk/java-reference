package za.co.reference.log4j.moreexamples.writerappender;

import java.io.*;
import org.apache.log4j.*;
public class WriterAppenderExample {

  static Logger logger = 
  Logger.getLogger("WriterAppenderExample.class");
    public static void main(String[] args) {
      try{
        FileOutputStream filename=
        new FileOutputStream("Writer.html");
        WriterAppender writeappender = 
        new WriterAppender(new HTMLLayout(),filename);
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