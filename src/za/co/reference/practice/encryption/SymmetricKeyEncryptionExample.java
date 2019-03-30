package za.co.reference.practice.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricKeyEncryptionExample{
	
	public static void main(String[] args){
		try{
			KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] rawKey = secretKey.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(rawKey, "Blowfish");
			
			String data = "Encrypt this data";
			
			Cipher encryptCipher = Cipher.getInstance("Blowfish");
			encryptCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] encryptedData = encryptCipher.doFinal(data.getBytes());
			StringBuffer encryptBuffer = new StringBuffer();
			for (int i = 0; i < encryptedData.length; i++){
				encryptBuffer.append(Integer.toHexString(0xFF & encryptedData[i]));
			}
			System.out.println("Encrypted: " + encryptBuffer.toString());
			
			Cipher decryptCipher = Cipher.getInstance("Blowfish");
			decryptCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] decryptedData = decryptCipher.doFinal(encryptedData);
			StringBuffer decryptBuffer = new StringBuffer();
			for (int i = 0; i < decryptedData.length; i++){
				decryptBuffer.append((char)decryptedData[i]);
			}
			System.out.println("Decrypted: " + decryptBuffer.toString());
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
