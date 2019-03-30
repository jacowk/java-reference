package za.co.reference.networking.tcp.urls;

import java.net.MalformedURLException;
import java.net.URL;

public class BParseURL{
	
	public static void main(String[] args){
		try{
			URL aURL = new URL("http://java.sun.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING");
			System.out.println("protocol = " + aURL.getProtocol());
			System.out.println("authority = " + aURL.getAuthority());
			System.out.println("host = " + aURL.getHost());
			System.out.println("port = " + aURL.getPort());
			System.out.println("path = " + aURL.getPath());
			System.out.println("query = " + aURL.getQuery());
			System.out.println("filename = " + aURL.getFile());
			System.out.println("ref = " + aURL.getRef());
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
	}

}
