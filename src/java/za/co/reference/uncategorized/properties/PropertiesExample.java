package za.co.reference.uncategorized.properties;

import java.io.IOException;
import java.util.Properties;

public class PropertiesExample{
	
	public static void main(String[] args){
		//See PortalServicesImpl line 135
		Properties properties = new Properties();
		try{
			properties.load(PropertiesExample.class.getResourceAsStream("./test.properties"));
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		System.out.println(properties.get("propertyone"));
		System.out.println(properties.get("propertytwo"));
		System.out.println(properties.get("propertythree"));
	}

}
