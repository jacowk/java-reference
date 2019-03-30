package za.co.reference.javaoracletutorial.url.creating;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * https://docs.oracle.com/javase/tutorial/networking/urls/creatingUrls.html
 * 
 * @author Jaco Koekemoer
 * Date: 2017-07-26
 *
 */
public class JavaTester {

	public static void main(String[] args) {
		try
		{
			/* Create a URL */
			URL myURL = new URL("http://example.com");
			
			/* Create a URL relative to another URL */
			URL pageURL = new URL("http://example.com/pages/");
			URL page1URL = new URL(pageURL, "page1.html"); /* new URL(URL baseURL, URL relativeURL) */
			URL page2URL = new URL(pageURL, "page2.html");
			
			/* URL pointing to an anchor */
			URL page1BottomURL = new URL(page1URL, "#BOTTOM");
			
			/* Another URL constructor */
			URL anotherURL = new URL("http", "example.com", "/pages/page1.html"); /* protocol, hostname, filename */
			URL yetAnotherURL = new URL("http", "example.com", 80, "/pages/page1.html"); /* protocol, hostname, port number, filename */
			
			/* URL with special characters */
			URL specialCharactersURL = new URL("http://example.com/hello%20world");
			
			/* URI automatically handles encoding */
			try
			{
				URI uri = new URI("http", "example.com", "/hello world/", "");
				URL url = uri.toURL();
			}
			catch (URISyntaxException e)
			{
				e.printStackTrace();
			}
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}
	
}
