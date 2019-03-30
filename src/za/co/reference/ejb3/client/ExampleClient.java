package za.co.reference.ejb3.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import za.co.reference.ejb3.session.ExampleEjbBean;
import za.co.reference.ejb3.session.ExampleEjbRemote;

public class ExampleClient{
	
	public static void main(String[] args){
		
	}
	
	private void sessionBeanSetup() throws NamingException{
		Properties properties = new Properties();
		properties.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs","=org.jboss.naming:org.jnp.interfaces");
		properties.put("java.naming.provider.url","localhost:1099");
		properties.put(Context.SECURITY_PRINCIPAL, "jacok");
		properties.put(Context.SECURITY_CREDENTIALS, "password");
		context = new InitialContext(properties);
		exampleEjbRemote = (ExampleEjbRemote)context.lookup(ExampleEjbBean.RemoteJNDIName);
	}
	
	private Context context;
	private ExampleEjbRemote exampleEjbRemote;

}
