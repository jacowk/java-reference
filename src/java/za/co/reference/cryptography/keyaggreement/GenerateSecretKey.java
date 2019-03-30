//package za.co.reference.cryptography.keyaggreement;
//
//import java.math.BigInteger;
//import java.security.KeyFactory;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.spec.X509EncodedKeySpec;
//
//import javax.crypto.KeyAgreement;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.DHParameterSpec;
//
///*
// *  Generating a Secret Key Using the Diffie-Hellman Key Agreement Algorithm
//Two parties use a key agreement protocol to generate identical secret keys for encryption without ever having to transmit the secret key. The protocol works by both parties agreeing on a set of values (a prime, a base, and a private value) which are used to generate a key pair. Generating a Parameter Set for the Diffie-Hellman Key Agreement Algorithm demonstrates how to generate the set of values.
//
//This example uses the set of values and generates a key pair. The public key is then exchanged with the other party and the secret key is generated. 
// */
//public class GenerateSecretKey{
//
//	// Retrieve the prime, base, and private value for generating the key pair.
//	// If the values are encoded as in
//	// Generating a Parameter Set for the Diffie-Hellman Key Agreement Algorithm,
//	// the following code will extract the values.
//	String[] values = valuesInStr.split(",");
//	BigInteger p = new BigInteger(values[0]);
//	BigInteger g = new BigInteger(values[1]);
//	int l = Integer.parseInt(values[2]);
//
//	try {
//	    // Use the values to generate a key pair
//	    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH");
//	    DHParameterSpec dhSpec = new DHParameterSpec(p, g, l);
//	    keyGen.initialize(dhSpec);
//	    KeyPair keypair = keyGen.generateKeyPair();
//
//	    // Get the generated public and private keys
//	    PrivateKey privateKey = keypair.getPrivate();
//	    PublicKey publicKey = keypair.getPublic();
//
//	    // Send the public key bytes to the other party...
//	    byte[] publicKeyBytes = publicKey.getEncoded();
//
//	    // Retrieve the public key bytes of the other party
//	    publicKeyBytes = ...;
//
//	    // Convert the public key bytes into a PublicKey object
//	    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKeyBytes);
//	    KeyFactory keyFact = KeyFactory.getInstance("DH");
//	    publicKey = keyFact.generatePublic(x509KeySpec);
//
//	    // Prepare to generate the secret key with the private key and public key of the other party
//	    KeyAgreement ka = KeyAgreement.getInstance("DH");
//	    ka.init(privateKey);
//	    ka.doPhase(publicKey, true);
//
//	    // Specify the type of key to generate;
//	    // see Listing All Available Symmetric Key Generators
//	    String algorithm = "DES";
//
//	    // Generate the secret key
//	    SecretKey secretKey = ka.generateSecret(algorithm);
//
//	    // Use the secret key to encrypt/decrypt data;
//	    // see Encrypting a String with DES
//	} catch (java.security.InvalidKeyException e) {
//	} catch (java.security.spec.InvalidKeySpecException e) {
//	} catch (java.security.InvalidAlgorithmParameterException e) {
//	} catch (java.security.NoSuchAlgorithmException e) {
//	}
//
//	
//}
