//package za.co.reference.cryptography.encryptobjectwithdes;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import javax.crypto.SealedObject;
//import javax.crypto.SecretKey;
//
//public class DesEncrypter{
//	
//	public static void main(String[] args){
//		try {
//		    // Generate a temporary key. In practice, you would save this key.
//		    // See also Encrypting with DES Using a Pass Phrase.
//		    SecretKey key = KeyGenerator.getInstance("DES").generateKey();
//
//		    // Prepare the encrypter
//		    Cipher ecipher = Cipher.getInstance("DES");
//		    ecipher.init(Cipher.ENCRYPT_MODE, key);
//
//		    // Seal (encrypt) the object
//		    SealedObject so = new SealedObject(new MySecretClass(), ecipher);
//
//		    // Get the algorithm used to seal the object
//		    String algoName = so.getAlgorithm();  // DES
//
//		    // Prepare the decrypter
//		    Cipher dcipher = Cipher.getInstance("DES");
//		    dcipher.init(Cipher.DECRYPT_MODE, key);
//
//		    // Unseal (decrypt) the class
//		    MySecretClass o = (MySecretClass)so.getObject(dcipher);
//		} catch (java.io.IOException e) {
//		} catch (ClassNotFoundException e) {
//		} catch (javax.crypto.IllegalBlockSizeException e) {
//		} catch (javax.crypto.BadPaddingException e) {
//		} catch (javax.crypto.NoSuchPaddingException e) {
//		} catch (java.security.NoSuchAlgorithmException e) {
//		} catch (java.security.InvalidKeyException e) {
//		}
//	}
//	
//	public class MySecretClass implements java.io.Serializable {
//	    String s = "the secret";
//	}
//	
//}
