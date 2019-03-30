package za.co.reference.practice.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashEncryptionExample{
	
	public static void main(String[] args){
		HashEncryptionExample hashEncryptionExample = new HashEncryptionExample();
		try{
			String data = "To be encrypted";
			System.out.println("SHA encryption: " + hashEncryptionExample.encrypt(MessageDigest.getInstance("SHA"), data));
			System.out.println("MD5 encryption: " + hashEncryptionExample.encrypt(MessageDigest.getInstance("MD5"), data));
			System.out.println("MD2 encryption: " + hashEncryptionExample.encrypt(MessageDigest.getInstance("MD2"), data));
		}
		catch (NoSuchAlgorithmException nsae){
			nsae.printStackTrace();
		}
	}
	
	public String encrypt(MessageDigest messageDigest, String data){
		messageDigest.update(data.getBytes());
		byte[] encryptedData = messageDigest.digest();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < encryptedData.length; i++){
			stringBuffer.append(Integer.toHexString(0xFF & encryptedData[i]));
		}
		return stringBuffer.toString();
	}

}
