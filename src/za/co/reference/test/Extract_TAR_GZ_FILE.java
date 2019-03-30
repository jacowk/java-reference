package za.co.reference.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

public class Extract_TAR_GZ_FILE {
	
	public static InputStream getInputStream(String tarFileName) throws Exception{
    
      if(tarFileName.substring(tarFileName.lastIndexOf(".") + 1, tarFileName.lastIndexOf(".") + 3).equalsIgnoreCase("gz")){
         System.out.println("Creating an GZIPInputStream for the file");
         return new GZIPInputStream(new FileInputStream(new File(tarFileName)));
    
      }else{
         System.out.println("Creating an InputStream for the file");
         return new FileInputStream(new File(tarFileName));
      }
   }
	
	private static void untar(InputStream in, String untarDir) throws IOException {
		
	  System.out.println("Reading TarInputStream... ");
      TarInputStream tin = new TarInputStream(in);
      TarEntry tarEntry = tin.getNextEntry();
      if(new File(untarDir).exists()){
	      while (tarEntry != null){
	         File destPath = new File(untarDir + File.separatorChar + tarEntry.getName());
	         System.out.println("Processing " + destPath.getAbsoluteFile());
	         if(!tarEntry.isDirectory()){
	            FileOutputStream fout = new FileOutputStream(destPath);
	            tin.copyEntryContents(fout);
	            fout.close();
	         }else{
	            destPath.mkdir();
	         }
	         tarEntry = tin.getNextEntry();
	      }
	      tin.close();
      }else{
         System.out.println("That destination directory doesn't exist! " + untarDir);
      }
		
	}
	
	private void run(){
		
		try {			
			String strSourceFile = "C:/test/prod20110228.gz";
			String strDest = "C:/test/";
			InputStream in = getInputStream(strSourceFile);
		
			untar(in, strDest);		
			
		}catch(Exception e) {
		
			e.printStackTrace();		
			System.out.println(e.getMessage());
		}
	}	
	
	public static void main(String[] strArgs) throws IOException{
		new Extract_TAR_GZ_FILE().run();
	}
}