package za.co.reference.cryptography.encryptfilewithdes;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DesEncrypterTest{
	
	public static void main(String[] args){
		try {
		    // Generate a temporary key. In practice, you would save this key.
		    // See also Encrypting with DES Using a Pass Phrase.
		    SecretKey key = KeyGenerator.getInstance("DES").generateKey();

		    // Create encrypter/decrypter class
		    DesEncrypter encrypter = new DesEncrypter(key);

		    // Encrypt
		    encrypter.encrypt(new FileInputStream("cleartext1"),
		        new FileOutputStream("ciphertext"));

		    // Decrypt
		    encrypter.decrypt(new FileInputStream("ciphertext"),
		        new FileOutputStream("cleartext2"));
		} catch (Exception e) {
		}
	}
	
}
