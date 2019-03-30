package za.co.reference.practice.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import za.co.reference.practice.ejb.session.TestBean;
import za.co.reference.practice.ejb.session.TestRemote;

public class Test{
	
	public void ejbLookup() throws Exception{
		//Set Properties
		Properties properties = new Properties();
		context = new InitialContext(properties);
		testRemote = (TestRemote)context.lookup(TestBean.RemoteJNDIName);
	}
	
	private Context context;
	private TestRemote testRemote;

}
