package za.co.reference.log4j.moreexamples.fileappender;

import org.apache.log4j.*;
public class FileAppenderExample {
  static Logger logger = Logger.getLogger("FileAppenderExample.class");
  public static void main(String[] args)throws Exception {
    FileAppender fileappender = 
    new FileAppender(new PatternLayout(),"output.txt");
    logger.addAppender(fileappender);
    logger.info("Log has been appended to your output.txt");  
    logger.info("See your output.txt");    
  }
}