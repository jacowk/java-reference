package za.co.reference.log4j.moreexamples.ttcclayout;

import org.apache.log4j.*;

public class TTCCLayoutExample {
  static Logger logger = Logger.getLogger("TTCCLayoutExample.class");
  public static void main(String[] args) {
    try
    {
      FileAppender fileappender = 
      new FileAppender(new TTCCLayout(),"TTCCoutput.txt");
      logger.addAppender(fileappender);
      logger.info("First Log");  
      logger.info("Second Log");  
      logger.info("Third Log");  
      logger.info("Fourth Log");  
      logger.info("See your TTCCoutput.txt");
      logger.info("Exiting from the Main method  ");
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}