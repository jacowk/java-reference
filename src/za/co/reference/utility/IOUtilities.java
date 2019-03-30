package za.co.reference.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IOUtilities{
	
	public static void main(String[] args){
		readFromConsole();
	}
	
	public static void readFromConsole(){
		Console console = System.console();
		if (console != null){
			System.out.print("[console] Enter something: ");
			String somethingEntered = console.readLine();
			System.out.println("[console] You entered: " + somethingEntered);
		}
		else{
			Scanner scanner = new Scanner(System.in);
			System.out.print("[scanner] Enter something: ");
			String somethingEntered = scanner.nextLine();
			System.out.println("[scanner] You entered: " + somethingEntered + "\n");
		}
	}
	
	/*
	 * Reading and Writing Files
	 */
	public static void writeByteArray(String filename, byte[] data){
		try{
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(data);
			fos.flush();
			fos.close();
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public static byte[] readByteArray(String filename){
		try{
			FileInputStream fis = new FileInputStream(filename);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int byteRead = 0;
			while ((byteRead = fis.read()) != -1){
				baos.write(byteRead);
			}
			fis.close();
			baos.flush();
			baos.close();
			return baos.toByteArray();
		}
		catch (FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		return new byte[0];
	}
	
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
	
	public static void writeToTextFileAppend(String file, String data){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
			out.write(data);
			out.newLine();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToTextFileOverwrite(String file, String data){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file, false));
			out.write(data);
			out.newLine();
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFromURL(URL url){
		try{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			int in = 0;
			String str;
			while ((str = bufferedReader.readLine()) != null) {
				System.out.println(str);
			}
			bufferedReader.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public static File getCurrentDirectory(){
		File directory = new File(".");
		try{
			System.out.println("The current directory: " + directory.getCanonicalPath());
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return directory;
	}
	
	public static void directoryExists(String path){
		File directory = new File(path);
		if (directory.exists()){
			System.out.println(path + " exists");
		}
		else{
			System.out.println(path + " does not exist");
		}
	}
	
	public static boolean isFile(String path){
		File file = new File(path);
		return file.isFile();
	}
	
	public static boolean isDirectory(String path){
		File directory = new File(path);
		return directory.isDirectory();
	}
	
	public static void createEmptyFile(String path){
		try {
	        File file = new File(path);
	        // Create file if it does not exist
	        boolean success = file.createNewFile();
	        if (success){
	            System.out.println(path + " was successfully created");
	        }
	        else{
	        	System.out.println(path + " was not created");
	        }
	    }
		catch (IOException e){
			e.printStackTrace();
	    }
	}
	
	public static void createDirectory(String path){
        File directory = new File(path);
        // Create file if it does not exist
        boolean success = directory.mkdir();
        if (success){
            System.out.println(path + " was successfully created");
        }
        else{
        	System.out.println(path + " was not created");
        }
	}
	
	public static String constructPath(List<String> pathItems){
		String path = "";
		for (String pathItem: pathItems){
			path += pathItem + File.separator;
		}
		return path;
	}
	
	public static URL convertFileToURL(String path){
		File file = new File(path);
		URI uri = null;
		uri = file.toURI();
		URL url = null;
		try{
			url = uri.toURL();
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
		return url;
	} 
	
	public static URI convertFileToURI(String path){
		File file = new File(path);
		URI uri = null;
		uri = file.toURI();
		return uri;
	}
	
	public static File convertURIToFile(URI uri){
		File file = new File(uri.getPath());
		return file;
	}
	
	public static void copyFile(File src, File dst){
		try{
			InputStream in = new FileInputStream(src);
	        OutputStream out = new FileOutputStream(dst);
	        
	        // Transfer bytes from in to out
	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0){
	            out.write(buf, 0, len);
	        }
	        in.close();
	        out.close();
		}
        catch (IOException ioe){
        	ioe.printStackTrace();
        }
    }

	public static long getFileSize(String path){
		File file = new File(path);
		return file.length();
	}
	
	public static boolean deleteFile(String path){
		File file = new File(path);
		return file.delete();
	}
	
	public static boolean renameFile(String oldFileName, String newFileName){
		File oldFile = new File(oldFileName);
		File newFile = new File(newFileName);
		return oldFile.renameTo(newFile);
	}
	
	public static boolean copyFileToDirectory(String filename, String directoryPath){
		File file = new File(filename);
		File directory = new File(directoryPath);
		return file.renameTo(new File(directory, file.getName()));
	}
	
	public static void copyDirectory(File srcDir, File dstDir){
        if (srcDir.isDirectory()){
            if (!dstDir.exists()){
                dstDir.mkdir();
            }
    
            String[] children = srcDir.list();
            for (int i=0; i<children.length; i++) {
                copyDirectory(new File(srcDir, children[i]),
                                     new File(dstDir, children[i]));
            }
        }
        else{
            copyFile(srcDir, dstDir);
        }
    }
    
    public static boolean deleteDirectoryWithContent(String path){
    	File directory = new File(path);
    	boolean success = directory.delete();
    	if (!success){
    		return deleteDirectory(directory);
    	}
    	return success;
    }
    
    private static boolean deleteDirectory(File directory){
    	if (directory.isDirectory()){
			String[] children = directory.list();
			for (int i = 0; i < children.length; i++){
				boolean success = deleteDirectory(new File(directory, children[i]));
				if (!success){
					return false;
				}
			}
		}
    	return directory.delete();
    }
    
    public static void listGivenDirectory(File directory){
    	String[] contents = directory.list();
    	try{
    		System.out.println("Directory listing of: " + directory.getCanonicalPath());
    	}
    	catch (IOException ioe){
    		ioe.printStackTrace();
    	}
    	for (int i = 0; i < contents.length; i++){
    		System.out.println("\t" + contents[i]);
    	}
    }
    
    public static void listCurrentDirectory(){
    	listGivenDirectory(getCurrentDirectory());
    }
    
    public static String[] listDirectoryContentsFilteredReturningStrings(String path, final String filterCriteria){
    	File directory = new File(path);
    	FilenameFilter filter = new FilenameFilter(){
			@Override
			public boolean accept(File directory, String name){
				//Lists all files starting with filterCriteria
				return name.startsWith(filterCriteria);
			}
    	};
    	return directory.list(filter);
    }
    
    public static File[] listDirectoryContentsFilteredReturningFileObjects(String path, final String filterCriteria){
    	File directory = new File(path);
    	FilenameFilter filter = new FilenameFilter(){
			@Override
			public boolean accept(File directory, String name){
				//Lists all files starting with filterCriteria
				return name.startsWith(filterCriteria);
			}
    	};
    	return directory.listFiles(filter);
    }
    
    /**
     * Just an example
     * @param path
     */
    private static void readRandomAccessFile(String path){
    	try{
            File f = new File("filename");
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
        
            // Read a character
            char ch = raf.readChar();
        
            // Seek to end of file
            raf.seek(f.length());
        
            // Append to the end
            raf.writeChars("aString");
            raf.close();
        }
    	catch (IOException e){
        	e.printStackTrace();
        }
    }
    
    private void readFromCommandLine(){
    	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("Enter x: ");
    	try{
    		String line = keyboard.readLine();
    	}
    	catch (IOException ioe){
    		ioe.printStackTrace();
    	}
    }
    
//    http://www.exampledepot.com/egs/java.io/ParseJava.html
	
}
