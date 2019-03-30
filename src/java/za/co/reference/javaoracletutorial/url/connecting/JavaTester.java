package za.co.reference.javaoracletutorial.url.connecting;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JavaTester {

	public static void main(String[] args) {
		try
		{
			URL myURL = new URL("http://example.com/");
			URLConnection myURLConnection = myURL.openConnection();
			myURLConnection.connect();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
}
