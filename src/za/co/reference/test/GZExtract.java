package za.co.reference.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GZExtract{

	public static void main(String[] args){
		String filename = "c:/test/prod20110228.gz";
		File destination = new File("C:/test/test.txt");
		GZIPInputStream gis = null;
		
		try{
			gis = new GZIPInputStream(new FileInputStream(new File(filename)));
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		FileOutputStream fout = null;
		
		try{
			fout = new FileOutputStream(destination);
			int in = 0;
			while ((in = gis.read()) != -1){
				fout.write(in);
			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		
		try{
			gis.close();
			fout.flush();
			fout.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
		
}