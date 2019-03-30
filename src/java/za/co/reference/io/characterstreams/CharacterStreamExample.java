package za.co.reference.io.characterstreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamExample{
	
	/*
	 * Converts 8 bit ASCII format to 16 bit Unicode, western format.
	 * Read directly from disk
	 */
	
	public static void main(String[] args){
		FileReader reader = null;
		FileWriter writer = null;
		
		try{
			reader = new FileReader("store.properties");
			writer = new FileWriter("out.properties");
			int c = 0; //holds character value in it's last 16 bits
			while ((c = reader.read()) != -1){
				writer.write(c);
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