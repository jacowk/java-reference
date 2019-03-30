//package za.co.reference.test;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.channels.FileChannel;
//
//import org.mule.RequestContext;
//import org.mule.api.MuleMessage;
//
//public class CopyFile{
//
//	public File process(FileInputStream fileInputStream){
//		MuleMessage message = RequestContext.getEventContext().getMessage();
//		System.out.println("Copying file: " + ((String) message.getProperty("originalFilename")));
//		copyFile(fileInputStream, getFileOutputStream(message));
//		System.out.println("Copying file done: " + ((String) message.getProperty("originalFilename")));
//		try{
//			System.out.println("Sleeping started: " + ((String) message.getProperty("originalFilename")));
//			Thread.sleep(30000);
//			System.out.println("Sleeping ended: " + ((String) message.getProperty("originalFilename")));
//		}
//		catch (InterruptedException ie){
//			ie.printStackTrace();
//		}
//		return getDestinationFile(message);
//	}
//	
//	private void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream){
//		FileChannel inputChannel = fileInputStream.getChannel();
//		FileChannel outputChannel = fileOutputStream.getChannel();
//		try{
//			inputChannel.transferTo(0, inputChannel.size(), outputChannel);
//			inputChannel.close();
//			outputChannel.close();
//		}
//		catch (IOException ioe){
//			ioe.printStackTrace();
//		}
//	}
//	
//	private File getSourceFile(MuleMessage message){
//		String sourceFileName = (String) message.getProperty("originalFilename");
//		String sourceDirectory = (String) message.getProperty("directory");
//		return new File(sourceDirectory + "/" + sourceFileName);
//	}
//	
//	private File getDestinationFile(MuleMessage message){
//		String destinationFileName = (String) message.getProperty("originalFilename");
//		return new File(destinationDirectory + "/" + destinationFileName);
//	}
//	
//	private FileOutputStream getFileOutputStream(MuleMessage message){
//		String destinationFileName = (String) message.getProperty("originalFilename");
//		File outputFile = new File(destinationDirectory + "/" + destinationFileName);
//		FileOutputStream fileOutputStream = null;
//		try{
//			fileOutputStream = new FileOutputStream(outputFile);
//		}
//		catch (FileNotFoundException fnfe){
//			fnfe.printStackTrace();
//		}
//		return fileOutputStream;
//	}
//	
//	private String destinationDirectory;
//
//}