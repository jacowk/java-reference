package za.co.reference.log4j.moreexamples.patternlayout;

import org.apache.log4j.*;
public class PatternLayoutExample {
static Logger logger = Logger.getLogger("PatternLayoutExample");
  public static void main(String[] args) {
    try
    {
      PatternLayout pattern = 
      new PatternLayout("%r [%t] %-5p %c %x - %m%n");
      FileAppender fileappend=new FileAppender(pattern,"Output.log");
      logger.addAppender(fileappend);
      logger.info("Hello !");
      logger.info("Welcome");
      logger.debug("Exiting from main method");      
    }catch(Exception e){
      System.out.println(e.getMessage());
    }    
  }
}