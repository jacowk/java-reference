package za.co.reference.networking.tcp.urls;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DConnectingToURL{
	
	public static void main(String[] args){
		try{
			URL url = new URL("http://www.google.com");
			URLConnection urlConnection = url.openConnection();
			urlConnection.connect();
			
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

}
