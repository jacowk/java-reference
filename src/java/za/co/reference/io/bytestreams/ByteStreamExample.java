package za.co.reference.io.bytestreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample{

	/*
	 * Programs use byte streams to perform input and output of 8-bit bytes. All byte stream classes are 
	 * descended from InputStream and OutputStream.
	 * Low-level I/O and should be avoided
	 * Read directly from disk
	 */
	public static void main(String[] args){
		ByteStreamExample byteStreamExample = new ByteStreamExample();
		byteStreamExample.process();
	}
	
	public void process(){
		FileInputStream in = null;
		FileOutputStream out = null;
		try{
			in = new FileInputStream("store.properties");
			out = new FileOutputStream("out.properties");
			int c; //Holds byte value in it's last 8 bits
			while ((c = in.read()) != -1){
				out.write(c);
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
				if (in != null){
					in.close();
				}
				if (out != null){
					out.close();
				}
			}
			catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
}