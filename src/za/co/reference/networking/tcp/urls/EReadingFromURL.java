package za.co.reference.networking.tcp.urls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EReadingFromURL{
	
	public static void main(String[] args){
		try{
			URL url = new URL("http://www.google.com");
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.
				getInputStream()));
			
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
