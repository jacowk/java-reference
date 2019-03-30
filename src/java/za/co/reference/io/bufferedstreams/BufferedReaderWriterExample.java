package za.co.reference.io.bufferedstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterExample{

	/*
	 * Reader and write lines per file.
	 * Read from buffered memory instead of directly from disk
	 */
	public static void main(String[] args){
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try{
			reader = new BufferedReader(new FileReader("store.properties"));
			writer = new BufferedWriter(new FileWriter("out.properties"));
			String input = null;
			while ((input = reader.readLine()) != null){
				writer.write(input + "\n");
				writer.flush();
			}
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
}