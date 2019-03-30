package za.co.reference.compression;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnZipExample{

	public static void main(String[] args){
		String filename = "test";
		try{
			ZipFile zipFile = new ZipFile(filename);
			Enumeration entries = zipFile.entries();
			while (entries.hasMoreElements()){
				ZipEntry zipEntry = (ZipEntry) entries.nextElement();
				if (!zipEntry.isDirectory()){
					unzipFile(zipFile, zipEntry);
				}
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public static void unzipFile(ZipFile zipFile, ZipEntry zipEntry) throws
		IOException{
		String filename = null;
		InputStream in = zipFile.getInputStream(zipEntry);
		OutputStream out = new FileOutputStream(filename);
	
		// Transfer bytes from in to out
	    byte[] buf = new byte[1024];
	    int len;
	    while ((len = in.read(buf)) > 0){
	        out.write(buf, 0, len);
	    }
	    in.close();
	    out.close();
	}
	
}