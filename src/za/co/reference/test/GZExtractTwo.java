package za.co.reference.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GZExtractTwo{

	public static void main(String[] args) throws IOException, FileNotFoundException{
		String filename = "c:/test/prod20110228.gz";
		File destination = new File("C:/test/test1.txt");
		GZIPInputStream gis = new GZIPInputStream(new FileInputStream(new File(filename)));
		BufferedInputStream bis = new BufferedInputStream(gis);
		FileOutputStream fout = new FileOutputStream(destination);
		BufferedOutputStream bos = new BufferedOutputStream(fout);
		
		int in = 0;
		
		/* Read/Write with buffers */
		while ((in = bis.read()) != -1){
			bos.write(in);
			bos.flush();
		}
		bos.flush();
		gis.close();
		bis.close();
		fout.close();
		bos.close();
		
		/* Read/Write without buffers */
//		while ((in = gis.read()) != -1){
//			fout.write(in);
//			fout.flush();
//		}
//		gis.close();
//		fout.close();
		
		
//		ByteArrayInputStream byteArrayInputStream = null;
//    	FileOutputStream fileOutputStream = null;
//    	BufferedInputStream bufferedInputStream = null;
//    	BufferedOutputStream bufferedOutputStream = null;
//		
//		byteArrayInputStream = new ByteArrayInputStream(gis);
//		bufferedInputStream = new BufferedInputStream(byteArrayInputStream);
//		fileOutputStream = new FileOutputStream(file);
//		bufferedOutputStream = new BufferedOutputStream(fileOutputStream, bufferLength);
//		int length = 0;
//		while ((length = bufferedInputStream.read(buffer, 0, bufferLength)) != -1){
//			bufferedOutputStream.write(buffer, 0, length);
//		}
//		bufferedOutputStream.flush();
//		bufferedOutputStream.close();
//		fileOutputStream.close();
//		bufferedInputStream.close();
//		byteArrayInputStream.close();
		
		
	}
		
}