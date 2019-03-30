package za.co.reference.log4j.moreexamples.example1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jExample {

    public Log4jExample() {
    }
    static Logger log = Logger.getLogger(Log4jExample.class);

    public static void main(String argsp[]) {
    	PropertyConfigurator.configure("src\\za\\co\\javastudent\\log4j\\example1\\log4j.properties");
        log.info("This is an info message.");
    }
}
