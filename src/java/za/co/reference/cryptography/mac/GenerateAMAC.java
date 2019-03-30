package za.co.reference.cryptography.mac;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

/*
 * MAC: Message Authentication Code
 * A MAC is like hash code for a sequence of bytes. Unlike a hash code, a MAC uses a secret key to generate 
 * the hash code, or more specifically, the message digest. A MAC is generally used to check the integrity or 
 * validity of information based on a secret key.
 * 
 */
public class GenerateAMAC{
	
	public static void main(String[] args){
		try {
		    // Generate a key for the HMAC-MD5 keyed-hashing algorithm; see RFC 2104
		    // In practice, you would save this key.
		    KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
		    SecretKey key = keyGen.generateKey();

		    // Create a MAC object using HMAC-MD5 and initialize with key
		    Mac mac = Mac.getInstance(key.getAlgorithm());
		    mac.init(key);

		    String str = "This message will be digested";

		    // Encode the string into bytes using utf-8 and digest it
		    byte[] utf8 = str.getBytes("UTF8");
		    byte[] digest = mac.doFinal(utf8);

		    // If desired, convert the digest into a string
		    String digestB64 = new sun.misc.BASE64Encoder().encode(digest);
		} catch (InvalidKeyException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		}

	}

}
