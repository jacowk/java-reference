package za.co.reference.uniformresourcelocators;

import java.net.MalformedURLException;
import java.net.URL;

public class UniformResourceLocatorExample{
	
	public static void main(String[] args){
		//TODO: Finish this example URIUtil.encodePath and URIUtil.decodePath
		//Check out the commons httpclient package at http://hc.apache.org/httpcomponents-client/index.html
		try{
			URL contentURL = new URL("localhost");
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
	}

}
