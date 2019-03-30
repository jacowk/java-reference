package za.co.reference.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PracticeWriteToTextFile{
	
	public void writeToFile(String data, File file){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
			out.write(data);
			out.newLine();
			out.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

}
