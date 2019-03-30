package za.co.reference.ftp;

import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPClientExample{
	
	//http://commons.apache.org/net/api-3.1/org/apache/commons/net/ftp/FTPClient.html
	//http://www.kodejava.org/examples/354.html
	
	public static void main(String[] args){
		FTPClientExample ftpClientExample = new FTPClientExample();
		ftpClientExample.createLocalDirectory();
		ftpClientExample.getFtpConnectionDetails();
		ftpClientExample.performFtp();
	}
	
	private void createLocalDirectory(){
		String localDirectoryName = LOCAL_DIRECTORY + "\\" + getTodaysDate();
		File localDirectory = new File(localDirectoryName);
		if (!localDirectory.exists()){
			System.out.println(localDirectoryName + " does not exist");
			if (!localDirectory.mkdir()){
				System.out.println(localDirectoryName + " could not be created");
			}
			else{
				System.out.println(localDirectoryName + " created successfully");
			}
		}
	}
	
	private void getFtpConnectionDetails(){
		Console console = System.console();
		if (console != null){
			System.out.print("[console] Enter connection url: ");
			connectionUrl = console.readLine();
			
			System.out.print("[console] Enter username: ");
			username = console.readLine();
			
			System.out.print("[console] Enter password: ");
			password = console.readLine();
		}
		else{
			Scanner scanner = new Scanner(System.in);
			System.out.print("[scanner] Enter connection url: ");
			connectionUrl = scanner.nextLine();
			
			System.out.print("[scanner] Enter username: ");
			username = scanner.nextLine();
			
			System.out.print("[scanner] Enter password: ");
			password = scanner.nextLine();
		}
	}
	
	private void performFtp(){
		FTPClientExample ftpClientExample = new FTPClientExample();
		FTPClient ftpClient = new FTPClient();
		FileOutputStream fos = null;
		try{
			System.out.println("Connecting...");
			ftpClient.connect(connectionUrl);
			System.out.print(ftpClient.getReplyString());
			int reply = ftpClient.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
		        System.err.println("FTP server refused connection.");
		        System.exit(1);
		    }
			System.out.println("Logging in...");
			boolean login = ftpClient.login(username, password);
			if (login){
				System.out.println("Login successful");
				System.out.println("Set binary file type");
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
				System.out.println("Changing directory to inbox");
				boolean changeDirectoryToInbox = ftpClient.changeWorkingDirectory("inbox");
				if (changeDirectoryToInbox){
					System.out.println("Change directory successful");
					System.out.println("Starting file retrieve...");
					retrieveFile(ftpClientExample, fos, "dosage1", ftpClient);
					retrieveFile(ftpClientExample, fos, "manufact1", ftpClient);
					retrieveFile(ftpClientExample, fos, "mimscat1", ftpClient);
					retrieveFile(ftpClientExample, fos, "prod" + ftpClientExample.getTodaysDate() + ".gz", 
						ftpClient);
				}
				else{
					throw new IOException("Could not change directory");
				}
				
				System.out.println("Logging out...");
				boolean logout = ftpClient.logout();
				if (logout){
					System.out.println("Logout successful");
					System.exit(0);
				}
			}
			else{
				System.out.println("Login failed...");
				System.exit(1);
			}
			
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				System.out.println("Disconnecting...");
				ftpClient.disconnect();
			}
			catch (IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	
	private void retrieveFile(FTPClientExample ftpClientExample, FileOutputStream fos, String filename, 
		FTPClient ftpClient){
		System.out.println("Retrieving " + filename + " file");
		try{
			fos = new FileOutputStream(LOCAL_DIRECTORY + ftpClientExample.getTodaysDate() + "\\" + 
				filename);
			//ftpClient.retrieveFile(remote, local);
			boolean retrieved = ftpClient.retrieveFile(filename, fos);
			if (retrieved){
				System.out.println(filename + " retrieved successfully");
			}
			else{
				System.out.println(filename + " could not be retrieved");
			}
			
			/*
			 * To upload
			 */
//			String filename = "Touch.dat";
//			fis = new FileInputStream(filename);
			
			/*
			 * To list files
			 */
//			String[] names = client.listNames();
//			for (String name : names){
//				System.out.println("Name = " + name);
//			}
//			
//			FTPFile[] ftpFiles = client.listFiles();
//			for (FTPFile ftpFile : ftpFiles){
//				//
//				// Check if FTPFile is a regular file
//				//
//				if (ftpFile.getType() == FTPFile.FILE_TYPE){
//					System.out.println("FTPFile: " + ftpFile.getName() + 
//					"; " + FileUtils.byteCountToDisplaySize(
//					ftpFile.getSize()));
//				}
//			}
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	private String getTodaysDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(new Date());
	}
	
	private final String LOCAL_DIRECTORY = "C:\\data\\nappi\\";
	private String connectionUrl;
	private String username;
	private String password;

}