package practicades;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JOptionPane;

public class DES {

    private DESKeySpec dks;
    private SecretKeyFactory skf;
    private SecretKey desKey;
    private Cipher cifrador;

    //Clave: Llave usada en el cifrado
    //Modo
    //  true: Cifrar
    //  false: Descifrar
    public DES(String clave, boolean mode) throws NoSuchAlgorithmException {
        try {
            this.cifrador = Cipher.getInstance("DES");
            this.dks = new DESKeySpec(clave.getBytes());
            this.skf = SecretKeyFactory.getInstance("DES");
            this.desKey = skf.generateSecret(dks);

            if (mode) {
                cifrador.init(Cipher.ENCRYPT_MODE, desKey);
            } else {
                cifrador.init(Cipher.DECRYPT_MODE, desKey);
            }

        } catch (InvalidKeyException | InvalidKeySpecException | NoSuchPaddingException ex) {
            Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Recibe un bloque de datos y retorna el bloque cifrado/descifrado
    public byte[] hacerDES(byte[] bloque) {
        return cifrador.update(bloque);
    }

    //Recibe el último bloque de datos del archivo que debe cifrarse/descifrarse
    public byte[] finalizar(byte[] bloque) {
        try {
            return cifrador.doFinal(bloque);
        } catch (IllegalBlockSizeException | BadPaddingException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error, la opción señalada no puede realizarse");
            //Logger.getLogger(DES.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
