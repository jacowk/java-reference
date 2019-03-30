package za.co.reference.cryptography.assymetrickey;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**This class is used to generate the Private and Public key file.
 * The Public.key file and Private.key file will be generated in the
 * current directory.
 * @author Debadatta Mishra(PIKU)
 *
 */

public class KeyCreator{
            /**
             * Object of type {@link PublicKey}
             */

            private PublicKey publicKey = null;
            /**
             * Object of type {@link PrivateKey}
             */
            private PrivateKey privateKey = null;

            /**Default constructor.
             * Here KeyPair object is initialized and
             * thereby public key and private key objects
             * are created.
             * @throws Exception
             */

            public KeyCreator() throws Exception{
                        super();
                        /*
                         * The following line is used to
                         * generate the Public and Private
                         * key.
                         */

                        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
                        publicKey = keyPair.getPublic();
                        privateKey = keyPair.getPrivate();
            }

            /**Method to return the {@link PublicKey}
             * @return the {@link PublicKey}
             */
            public PublicKey getPublicKey(){
                        return publicKey;
            }

            /**Method to return the {@link PrivateKey}
             * @return the {@link PrivateKey}
             */
            public PrivateKey getPrivateKey(){
                        return privateKey;
            }

            /**Method used to write the Public or Private
             * key file.
             * @param filename of type String indicating
             * the name of Public or Private key
             * @param contents of the key
             */

            public void writeKey(String filename, byte[] contents){
        try
        {
            FileOutputStream fos = new FileOutputStream(filename);
            fos.write(contents);
            fos.flush();
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}