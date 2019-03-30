package za.co.reference.io.datastreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamExample{

	/*
	 * Data streams support binary I/O of primitive data type values (boolean, char, byte, short, int, long, 
	 * float, and double) as well as String values.
	 */
	public static void main(String[] args){
		DataStreamExample dataStreamExample = new DataStreamExample();
		dataStreamExample.writeData();
		dataStreamExample.readData();
	}
	
	private void writeData(){
		DataOutputStream output = null;
		try{
			output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
			output.writeDouble(12.34);
			output.writeInt(456);
			output.writeUTF("Test string");
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				output.close();
			}
			catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
	private void readData(){
		double doubleInput;
		int intInput;
		String stringInput;
		DataInputStream input = null;
		try{
			input = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
			while (true){
				doubleInput = input.readDouble();
				intInput = input.readInt();
				stringInput = input.readUTF();
				System.out.println(doubleInput + ", " + intInput + ", " + stringInput);
			}
		}
		catch (EOFException eofe){
			System.out.println("Done");
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				input.close();
			}
			catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
}