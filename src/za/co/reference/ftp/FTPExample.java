package za.co.reference.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FTPExample{
	
	/*
	 * This is a simple example. There are other ways to FTP files.
	 */
	public static void main(String[] args){
		URL url = null;
		try{
			url = new URL("ftp://user01:pass1234@ftp.foo.com/README.txt;type=i");
		}
		catch(MalformedURLException mue){
			mue.printStackTrace();
		}
		
		URLConnection urlc = null;
		InputStream is = null;
		OutputStream os = null;
		try{
			urlc = url.openConnection();
			is = urlc.getInputStream(); // To download
			os = urlc.getOutputStream(); // To upload
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

}
