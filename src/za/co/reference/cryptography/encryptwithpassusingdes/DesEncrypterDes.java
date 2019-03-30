package za.co.reference.cryptography.encryptwithpassusingdes;

public class DesEncrypterDes{
	
	public static void main(String[] args){
		// Here is an example that uses the class
		try {
		    // Create encrypter/decrypter class
		    DesEncrypter encrypter = new DesEncrypter("My Pass Phrase!");

		    // Encrypt
		    String encrypted = encrypter.encrypt("Don't tell anybody!");

		    // Decrypt
		    String decrypted = encrypter.decrypt(encrypted);
		} catch (Exception e) {
		}

	}

}
