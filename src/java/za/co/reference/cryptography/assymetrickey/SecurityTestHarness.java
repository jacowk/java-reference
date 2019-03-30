package za.co.reference.cryptography.assymetrickey;

import java.security.PrivateKey;
import java.security.PublicKey;

/**This is a test harness class used to
 * encrypt and decrypt the string based
 * upon the Public and Private key.
 * This class also helps to test how
 * Public and Private key can be created.
 * @author Debadatta Mishra(PIKU)
 *
 */
public class SecurityTestHarness
{
            public static void main(String[] args)
            {
                        try
                        {
                                    /*
                                     * The following lines will generate the
                                     * PublicKey and PrivateKey files.
                                     */
                                    KeyCreator keyCreator = new KeyCreator();
                                    PublicKey publicKey = keyCreator.getPublicKey();
                                    PrivateKey privateKey = keyCreator.getPrivateKey();
                                    
                                    /*
                                     * Generate two files named Public.key and Private.key
                                     */
                                    keyCreator.writeKey("Public.key", publicKey.getEncoded());
                                    keyCreator.writeKey("Private.key", privateKey.getEncoded());
                                    
                                    /*
                                     * Get the public and private key
                                     */
                                    KeyReader keyReader = new KeyReader();
                                    PublicKey publicKey2 = keyReader.getPublicKey("Public.key");
                                    System.out.println("Public Key----"+publicKey2);
                                    PrivateKey privateKey2 = keyReader.getPrivateKey("Private.key");
                                    System.out.println("Private Key----"+privateKey2);

                                    String str = "Hi, Hello World, Welcome to the World of Java";
                                    byte[] stringBytes = str.getBytes();
                                    
                                    /*
                                     * Encrypt using private key
                                     */
                                    byte[] encryptedBytes = SecurityUtil.getEncryptedBytes(
                                                            stringBytes, privateKey2);
                                    String encryptedString = new String(encryptedBytes);
                                    System.out.println("EncryptedString----"+encryptedString);
                                  
                                    /*
                                     * Decrypt using public key
                                     */
                                    byte[] decryptedBytes = SecurityUtil.getDecryptedBytes(encryptedBytes, publicKey2);
                                    System.out.println("Decrypted String----"+new String(decryptedBytes));
                        }
                        catch( Exception e )
                        {
                                    e.printStackTrace();
                        }
            }
}