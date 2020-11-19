/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author user1
 */
public class DES {

    private final String clave;
    private DESKeySpec dks;
    private SecretKeyFactory skf;
    private SecretKey desKey;
    private Cipher cifrador;

    public DES(String clave, boolean mode) throws NoSuchAlgorithmException {
        this.clave = clave;
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

    public byte[] hacerDES(byte[] bloque) {
        return cifrador.update(bloque);
    }

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
