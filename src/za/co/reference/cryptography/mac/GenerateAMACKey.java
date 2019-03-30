package za.co.reference.cryptography.mac;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class GenerateAMACKey{

	public static void main(String[] args){
		try {
		    // Generate a key for the HMAC-MD5 keyed-hashing algorithm
		    KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
		    SecretKey key = keyGen.generateKey();

		    // Generate a key for the HMAC-SHA1 keyed-hashing algorithm
		    keyGen = KeyGenerator.getInstance("HmacSHA1");
		    key = keyGen.generateKey();
		} catch (java.security.NoSuchAlgorithmException e) {
		}

	}
	
}
