package za.co.reference.cryptography.symmetrickey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricKeyEncryptionIOExample{
	
	public static void main(String[] args){
		try{
			/* Setup key */
			KeyGenerator keyGenerator = KeyGenerator.getInstance(ENCRYPTION_TYPE);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] rawKey = secretKey.getEncoded();
			SecretKeySpec secretKeySpec = new SecretKeySpec(rawKey, ENCRYPTION_TYPE);
			
			String data = "Encrypt this data";
			
			/* Encryption */
			Cipher encryptCipher = Cipher.getInstance(ENCRYPTION_TYPE);
			encryptCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] encryptedData = encryptCipher.doFinal(data.getBytes());
			
			StringBuffer encryptBuffer = new StringBuffer();
			for (int i = 0; i < encryptedData.length; i++){
				encryptBuffer.append(Integer.toHexString(0xFF & encryptedData[i]));
			}
			System.out.println("Encrypted: " + encryptBuffer.toString());
			
			writeData(encryptedData, ENCRYPTION_FILE);
			writeData(secretKeySpec.getEncoded(), CIPHER_SETTINGS_FILE);
			
			/* Decryption */
			byte[] ioEncryptedData = readData(ENCRYPTION_FILE);
			SecretKeySpec ioSecretKeySpec = new SecretKeySpec(readData(CIPHER_SETTINGS_FILE), ENCRYPTION_TYPE);
			Cipher decryptCipher = Cipher.getInstance(ENCRYPTION_TYPE);
			decryptCipher.init(Cipher.DECRYPT_MODE, ioSecretKeySpec);
			byte[] decryptedData = decryptCipher.doFinal(ioEncryptedData);
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
	
	public static void writeData(byte[] data, String filename){
		try{
			FileOutputStream fos = new FileOutputStream(filename);
			fos.write(data);
			fos.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static byte[] readData(String filename){
		try{
			File file = new File(filename);
			FileInputStream fis = new FileInputStream(file);
			
			//Untested
//			int character = 0;
//			StringBuffer inputBuffer = new StringBuffer();
//			while ((character = fis.read()) != -1){
//				inputBuffer.append(character);
//			}
//			byte[] data = new byte[inputBuffer.length()];
//			return inputBuffer.toString().getBytes();
			
			byte[] temp = new byte[(int)file.length()];
			int bytesRead = fis.read(temp);
			byte[] data = new byte[bytesRead];
			System.arraycopy(temp, 0, data, 0, bytesRead);
			return data;

		}
		catch (Exception e){
			e.printStackTrace();
		}
		return new byte[0];
	}
	
	private static final String ENCRYPTION_TYPE = "Blowfish";
	private static final String ENCRYPTION_FILE = "SKE_EncryptedData";
	private static final String CIPHER_SETTINGS_FILE = "SKE_CipherSettings";
	
}
