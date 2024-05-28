package encriptacion;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;



public class ProcesoEncriptarRSA implements InterfaceEncriptar{
    private static final String ALGORITHM = "RSA";
    @Override
    public String encryptar(String message, String password) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] mensajeEncriptado = cipher.doFinal(message.getBytes());

        return new String(mensajeEncriptado);
    }
}
