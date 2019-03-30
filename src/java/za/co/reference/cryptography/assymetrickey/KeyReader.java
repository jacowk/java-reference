package za.co.reference.cryptography.assymetrickey;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * This class is used to read the Private and Public key
 * files generated using the Java's Asysmmetric Security
 * system.
 * @author Debadatta Mishra(PIKU)
 *
 */

public class KeyReader
{
            /**
             * Object of type {@link KeyFactory}
             */

            private KeyFactory keyFactory = null;
            /**
             * Default constructor to initialize the
             * keyFactory.
             */

            public KeyReader()
            {
                        super();
                        try
                        {
                                    keyFactory = KeyFactory.getInstance("RSA");
                        }
                        catch( Exception e )
                        {
                                    e.printStackTrace();
                        }
            }

            /**This method is used to read the bytes from the file.
             * The file can be a Public key file or a Private key
             * file. In this file, you have stored the security key,
             * based upon which encryption and decryption can be
             * performed.
             * @param fileName of type String indicating the file name
             * @return the bytes from the file
             * @throws Exception
             */

            private byte[] getKeyData( String fileName ) throws Exception
            {
                        FileInputStream fis = new FileInputStream(fileName);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int b;
                        try
                        {
                                    while ((b = fis.read()) != -1)
                                    {
                                                baos.write(b);
                                    }
                                    fis.close();
                                    baos.flush();
                                    baos.close();
                        } catch (IOException e) {
                                    e.printStackTrace();
                        }
                        return baos.toByteArray();
            }

            /**This method is used to return the object of type
             * {@link PrivateKey}. In this method you have to pass
             * the file name of the Private.key file.
             * @param filename of type String indicating the
             * file name.
             * @return the object of type {@link PrivateKey}
             * @throws Exception
             */

            public PrivateKey getPrivateKey( String filename ) throws Exception
            {
                        PrivateKey privateKey = null;
                        try
                        {
                                    byte[] keydata = getKeyData(filename);
                                    PKCS8EncodedKeySpec encodedPrivateKey = new PKCS8EncodedKeySpec(keydata);
                                    privateKey = keyFactory.generatePrivate(encodedPrivateKey);
                        }
                        catch( Exception e )
                        {
                                    e.printStackTrace();
                        }
                        return privateKey;
            }

            /**This method is used to return the object of type
             * {@link PublicKey}. In this method you have to pass
             * the file name of the Public.key file.
             * @param filename of type String indicating the
             * file name.
             * @return the object of type {@link PublicKey}
             * @throws Exception
             */

            public PublicKey getPublicKey( String filename ) throws Exception
            {
                        PublicKey publicKey = null;
                        try
                        {
                                    byte[] keydata = getKeyData(filename);
                                    X509EncodedKeySpec encodedPublicKey = new X509EncodedKeySpec(keydata);
                                    publicKey = keyFactory.generatePublic(encodedPublicKey);
                        }
                        catch( Exception e )
                        {
                                    e.printStackTrace();
                        }
                        return publicKey;
            }

}