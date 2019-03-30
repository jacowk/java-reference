package za.co.reference.compression;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

public class GZUncompressExample{
	
	public static void main(String[] args){
		String filename = "test.gz";
		GZIPInputStream gzipInputStream = null;
		OutputStream out = null;
		try{
			gzipInputStream = new GZIPInputStream(new FileInputStream(filename));
			out = new FileOutputStream(filename);
			byte[] buf = new byte[1024];
	        int len;
	        while ((len = gzipInputStream.read(buf)) > 0){
	            out.write(buf, 0, len);
	        }
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				gzipInputStream.close();
		        out.close();
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}

}