package za.co.reference.io.bufferedstreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamReaderWriterExample{

	public static void main(String[] args){
		BufferedInputStream input = null;
		BufferedOutputStream output = null;
		try{
			input = new BufferedInputStream(new FileInputStream("store.properties"));
			output = new BufferedOutputStream(new FileOutputStream("out.properties"));
			int c;
			while((c = input.read()) != -1){
				output.write(c);
				output.flush();
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
				if (input != null){
					input.close();
				}
				if (output != null){
					output.close();
				}
			}
			catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
}