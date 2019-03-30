package za.co.reference.log4j.moreexamples.appender;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class AppenderEx1{
	
	public static void main(String[] args){
		FileAppender a0 = null;
		FileAppender a1 = null;
		try{
			a0 = new FileAppender(new SimpleLayout(), "a0.log");
			a1 = new FileAppender(new SimpleLayout(), "a1.log");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		Logger root = Logger.getRootLogger();
		root.addAppender(a0);
		
		Logger x = Logger.getLogger("x");
		x.addAppender(a1);
		
		Logger xyz = Logger.getLogger("x.y.z");
		
		xyz.debug("Some message");
		xyz.info("Another message");
	}

}
