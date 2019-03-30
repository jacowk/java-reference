package za.co.reference.log4j.moreexamples.htmllayout;

import org.apache.log4j.*;

public class HTMLLayoutExample {
  static Logger logger = Logger.getLogger("HTMLLayoutExample.class");
  public static void main(String[] args)throws Exception {
    FileAppender fileappender = 
    new FileAppender(new HTMLLayout(),"HTMLFile.html");
    logger.addAppender(fileappender);
    logger.info("Welcome");
    logger.info("to");
    logger.info("Rose India");
    logger.info("-----------");
  }
}