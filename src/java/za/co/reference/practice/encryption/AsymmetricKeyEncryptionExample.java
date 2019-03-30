package za.co.reference.practice.encryption;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class AsymmetricKeyEncryptionExample{
	
	public static void main(String[] args){
		try{
			//Generate a Public/Private key pair
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			
			String data = "Encrypt this text";
			
			//Encryption
			Cipher encryptCipher = Cipher.getInstance("RSA");
			encryptCipher.init(Cipher.ENCRYPT_MODE, privateKey);
//			encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] encrypted = encryptCipher.doFinal(data.getBytes());
			StringBuffer encryptBuffer = new StringBuffer();
			for (int i = 0; i < encrypted.length; i++){
				encryptBuffer.append(Integer.toHexString(0xFF & encrypted[i]));
			}
			System.out.println("Encrypted: " + encryptBuffer.toString());
			
			//Decryption
			Cipher decryptCipher = Cipher.getInstance("RSA");
			decryptCipher.init(Cipher.DECRYPT_MODE, publicKey);
//			decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] decrypted = decryptCipher.doFinal(encrypted);
			StringBuffer decryptBuffer = new StringBuffer();
			for (int i = 0; i < decrypted.length; i++){
				decryptBuffer.append((char)decrypted[i]);
			}
			System.out.println("Decrypted: " + decryptBuffer.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
