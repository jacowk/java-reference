package za.co.reference.test;

import java.io.File;

public class TestFile{

	public static void main(String[] args) throws Exception{
		File file = new File("C:\\test1.txt");
		file.createNewFile();
	}
	
}