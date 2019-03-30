package za.co.reference.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreProperties{
	
	public static void main(String[] args){
		Properties props = new Properties();
		props.setProperty("one", "value one");
		props.setProperty("two", "value two");
		props.setProperty("three", "value three");
		
		try{
			props.store(new FileOutputStream("store.properties"), "Some comment");
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

}