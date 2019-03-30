package za.co.reference.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class LoadProperties{

	public static void main(String[] args){
		Properties properties = new Properties();
		FileInputStream in = null;
		try{
			in = new FileInputStream("store.properties");
			/* Load properties */
			properties.load(in);
			
			/* List properties using keySet */
			Set keys = properties.keySet();
			for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				System.out.println((String) object + ": " + properties.getProperty((String) object));
			}
			
			/* Using getProperty */
			System.out.println("\none: " + properties.getProperty("one"));
			System.out.println("two: " + properties.getProperty("two"));
			System.out.println("three: " + properties.getProperty("three"));
			
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				in.close();
			}
			catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
}