package za.co.reference.cryptography.assymetrickey;

import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

 
/**This is a utility class to provide
 * encryption and decryption based upon
 * the key. The key can be your either
 * Public or Private .
 * @author Debadatta Mishra(PIKU)
 *
 */
public class SecurityUtil{
            /**
             * Object of type {@link Cipher}
             */
			private static Cipher cipher = null;
            /*
             * The following static is used to
             * initialize the Cipher object
             */
            static
            {
                        try
                        {
                                    cipher = Cipher.getInstance("RSA");
                        }
                        catch( Exception e )
                        {
                                    e.printStackTrace();
                        }
            }

            /**Method used to encrypt the string and return as bytes.
             * Here the input parameter will be your Private key.
             * You have to encrypt the string using your private
             * key at your end.
             * @param messsageBytes , it is the bytes from the
             * string to encrypt
             * @param privateKey of type {@link PrivateKey}
             * @return encrypted bytes
             * @throws Exception
             */
            public static byte[] getEncryptedBytes( byte[] messsageBytes , PrivateKey privateKey) throws Exception
            {
                        byte[] encryptedBytes = null;
                        cipher.init(Cipher.ENCRYPT_MODE , privateKey );
                        encryptedBytes = cipher.doFinal(messsageBytes);
                        return encryptedBytes;
            }

            /**Method used to decrypt the string and return as bytes.
             * Here the input parameter will be your Public key.
             * You have to decrypt the string using your Public
             * key at the destination end.
             * @param messsageBytes , it is the bytes from the
             * string to encrypt
             * @param publicKey of type {@link PublicKey}
             * @return decrypted bytes
             * @throws Exception
             */
            public static byte[] getDecryptedBytes( byte[] messsageBytes , PublicKey publicKey)throws Exception
            {
                        byte[] decryptedBytes = null;
                        cipher.init(Cipher.DECRYPT_MODE , publicKey );
                        decryptedBytes = cipher.doFinal( messsageBytes );
                        return decryptedBytes;
            }

}