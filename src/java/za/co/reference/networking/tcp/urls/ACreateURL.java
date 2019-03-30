package za.co.reference.networking.tcp.urls;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ACreateURL{
	
	public static void main(String[] args){
		try{
			/* Example URL: http://www.someurl.com/ */
			URL urlOne = new URL("http://www.someurl.com");
			
			/* Creating a URL Relative to Another
			http://www.gamelan.com/pages/Gamelan.net.html */
			URL urlTwo = new URL("http://www.gamelan.com/pages/");
			URL relativeURL = new URL(urlTwo, "Gamelan.net.html");
			
			/* Other constructors */
			URL urlThree = new URL("http", "www.gamelan.com", "/pages/Gamelan.net.html");
			//http://www.gamelan.com:80/pages/Gamelan.net.html
			URL urlFour = new URL("http", "www.gamelan.com", 80, "/pages/Gamelan.net.html");
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
		
		/* Convert URI to URL */
		URI uri = null;
		try{
			uri = new URI("http://www.gamelan.com/pages/Gamelan.net.html");
		}
		catch (URISyntaxException e){
			e.printStackTrace();
		}
		
		try{
			URL url = uri.toURL();
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
	}

}
