package za.co.reference.cryptography.keyaggreement;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.spec.DHParameterSpec;

/*
 *  Generating a Parameter Set for the Diffie-Hellman Key Agreement Algorithm
Two parties use a key agreement protocol to generate identical secret keys for encryption without ever having to transmit the secret key. The protocol works by both parties agreeing on a set of values (a prime, a base, and a private value) which are used to generate a key pair. This example demonstrates how to generate the set of values.

The two parties then exchange the generated public keys and then use it to compute the secret encryption key. This is demonstrated in Generating a Secret Key Using the Diffie-Hellman Key Agreement Algorithm. 
 */
public class ParameterSet{
	
	public static void main(String[] args) {
		
	}
	
	// Returns a comma-separated string of 3 values.
	// The first number is the prime modulus P.
	// The second number is the base generator G.
	// The third number is bit size of the random exponent L.
	public static String genDhParams() {
	    try {
	        // Create the parameter generator for a 1024-bit DH key pair
	        AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator.getInstance("DH");
	        paramGen.init(1024);

	        // Generate the parameters
	        AlgorithmParameters params = paramGen.generateParameters();
	        DHParameterSpec dhSpec
	            = (DHParameterSpec)params.getParameterSpec(DHParameterSpec.class);

	        // Return the three values in a string
	        return ""+dhSpec.getP()+","+dhSpec.getG()+","+dhSpec.getL();
	    } catch (NoSuchAlgorithmException e) {
	    } catch (InvalidParameterSpecException e) {
	    }
	    return null;
	}


}
