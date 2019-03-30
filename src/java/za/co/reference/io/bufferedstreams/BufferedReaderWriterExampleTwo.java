package za.co.reference.io.bufferedstreams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedReaderWriterExampleTwo{

	public static void main(String[] args){
		BufferedReader reader = null;
		PrintWriter writer = null;
		try{
			reader = new BufferedReader(new FileReader("store.properties"));
			writer = new PrintWriter(new FileWriter("out.properties"));
			String input = null;
			while ((input = reader.readLine()) != null){
				writer.println(input);
				writer.flush();
			}
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				if (reader != null){
					reader.close();
				}
				if (writer != null){
					writer.close();
				}
			}
			catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
}
