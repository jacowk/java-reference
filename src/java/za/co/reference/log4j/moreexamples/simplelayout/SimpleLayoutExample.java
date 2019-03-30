package za.co.reference.log4j.moreexamples.simplelayout;

import org.apache.log4j.*;
public class SimpleLayoutExample{
static Logger logger = 
  Logger.getLogger("SimpleLayoutExample.class"); 
  public static void main (String[] args) {
    try
    {
      FileAppender fileappender = 
      new FileAppender(new SimpleLayout(),"SimpleLog.log");
      logger.addAppender(fileappender);
      logger.info("First Log");  
      logger.info("Second Log");  
      logger.info("Third Log");  
      logger.info("Fourth Log");  
      logger.info("See your SimpleLog.log");
      logger.info("Exiting from the Main method  ");
    }catch(Exception e){
      e.printStackTrace();
    }    
  }
}