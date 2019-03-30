package za.co.reference.javaoracletutorial.url.read;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class JavaTester {

	public static void main(String[] args) throws Exception {
		URL oracle = new URL("http://www.oracle.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}
	
}
