package za.co.reference.javaoracletutorial.test;

import java.net.MalformedURLException;
import java.net.URL;

public class JavaTester
{
	
	public static void main(String[] args)
	{
		try
		{
			URL url = new URL("http://www.example.com/this/is/a/path/page.html#TOP");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getFile());
			System.out.println(url.getQuery());
			System.out.println(url.getPath());
			System.out.println(url.getRef());
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}

}
