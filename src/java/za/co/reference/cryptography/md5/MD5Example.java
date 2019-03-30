package za.co.reference.cryptography.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Example{
	
	public static void main(String[] args){
		/*
		 * Example 1
		 */
		try{
			String data = "hWe3g6";
			byte[] dataToBeEncrypted = data.getBytes();
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(dataToBeEncrypted);
			byte[] hash = messageDigest.digest();
			
			//Convert to Hex
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; i++){
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
			System.out.println(hexString.toString());
		}
		catch (NoSuchAlgorithmException nsae){
			nsae.printStackTrace();
		}

	}

}
