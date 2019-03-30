package za.co.reference.connectivitutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO{
	
	public List<String> readFile(String filePath)
	{
		List<String> fileContents = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try
		{
			bufferedReader = new BufferedReader(new FileReader(filePath));
			String inLine = null;
			while ((inLine = bufferedReader.readLine()) != null)
			{
				fileContents.add(inLine);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bufferedReader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return fileContents;
	}

	public void writeToFile(String data){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\SourceChanges.txt", true));
			out.write(data);
			out.newLine();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String[] listContents(String directoryString)
	{
		File directory = new File(directoryString);
		return directory.list();
	}
	
	public static void rename(String sourceFilename, String destFileFilename)
	{
		File sourceFile = new File(sourceFilename);
		File destFile = new File(destFileFilename);
		sourceFile.renameTo(destFile);
	}
	
}