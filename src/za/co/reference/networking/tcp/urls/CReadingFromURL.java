package za.co.reference.networking.tcp.urls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CReadingFromURL{
	
	/* This example reads directly from a URL */
	public static void main(String[] args){
		try{
			URL url = new URL("http://www.google.com");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine = null;
			while ((inputLine = bufferedReader.readLine()) != null){
				System.out.println(inputLine);
			}
			bufferedReader.close();
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

}
