package za.co.reference.networking.tcp.urls;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class FWritingToURL{
	
	public static void main(String[] args){
		try{
			String dataToSend = "Some data to send";
			
			/* Before sending, the data must be encoded */
			String encodedDataToSend = URLEncoder.encode(dataToSend);
			
			/* Prepare connection */
			URL url = new URL("http://www.someurl.com");
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream());
			outputStreamWriter.write(encodedDataToSend);
			outputStreamWriter.close();
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

}
