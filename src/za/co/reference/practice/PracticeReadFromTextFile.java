package za.co.reference.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PracticeReadFromTextFile{
	
	public static List<Object> readFromTextFile(String file){
		List<Object> objectList = new LinkedList<Object>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String str;
			while ((str = in.readLine()) != null) {
				objectList.add(str);
			}
			in.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return objectList;
	}

}
